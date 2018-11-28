(ns luminus-spike.test.handler
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer :all]
            [luminus-spike.handler :refer :all]
            [luminus-spike.middleware.formats :as formats]
            [muuntaja.core :as m]
            [mount.core :as mount]))

(defn parse-json [body]
  (m/decode formats/instance "application/json" body))

(use-fixtures
  :once
  (fn [f]
    (mount/start #'luminus-spike.config/env
                 #'luminus-spike.handler/app)
    (f)))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= 404 (:status response))))))
