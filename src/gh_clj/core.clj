(ns gh-clj.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clojure.string :as string]
            [tentacles.issues :as issues]
            [tentacles.repos :as repos])
  (:gen-class))

(def cli-options
  [["-v" nil "Verbosity level; may be specified multiple times to increase value"
    ;; If no long-option is specified, an option :id must be given
    :id :verbosity
    :default 0
    ;; Use assoc-fn to create non-idempotent options
    :assoc-fn (fn [m k _] (update-in m [k] inc))]
   ["-u" "--user USER" "User"]
   ["-r" "--repo REPO" "Repository"]
   ["-h" "--help"]])

(defn usage [options-summary]
  (->> ["A command line interface to the Github API."
        ""
        "Usage: program-name [options] subcommand"
        ""
        "Options:"
        options-summary
        ""
        "Subcommands:"
        "  issues   List all the issues"
        "  users    List all users"
        ""
        "Please refer to the manual page for more information."]
       (string/join \newline)))

(defn error-msg [errors]
  (str "The following errors occurred while parsing your command:\n\n"
       (string/join \newline errors)))

(defn exit [status msg]
  (println msg)
  (System/exit status))

(defn issues [user repo]
  (println
   (->> (issues/issues user repo)
        (map (juxt :number :title (comp :login :user) :comments))
        (sort-by first)
        (string/join \newline))))

(defn user-repos [user]
  (println (string/join \newline (map :name (repos/user-repos user)))))

(defn -main [& args]
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    ;; Handle help and error conditions
    (cond
      (:help options) (exit 0 (usage summary))
      (not= (count arguments) 1) (exit 1 (usage summary))
      errors (exit 1 (error-msg errors)))
    (case (first arguments)
      "issues" (issues (:user options) (:repo options))
      "repos" (user-repos (:user options))
      (exit 1 (usage summary)))))
