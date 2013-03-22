(ns clojure-course-task02.core
  (:gen-class))


(defn find-files [file-name path]
  (->> (file-seq (clojure.java.io/file path))
       (filter (comp (partial re-matches (re-pattern file-name)) (memfn getName)) )
       (pmap (memfn getName))))


(defn usage []
  (println "Usage: $ run.sh file_name path"))

(defn -main [file-name path]
  (if (or (nil? file-name)
          (nil? path))
    (usage)
    (do
      (println "Searching for " file-name " in " path "...")
      (dorun (map println (find-files file-name path))))))
