CREATE DATABASE "ResourcesRequests"
-- DDL
CREATE TABLE REQUEST_RESOURCE(
    request_resource_id INT AUTO_INCREMENT PRIMARY KEY,
    creation_date timestamp,
    description VARCHAR(255) NOT NULL UNIQUE,
    due_date timestamp,
    title VARCHAR(255) NOT NULL
);

INSERT INTO REQUEST_RESOURCE (REQUEST_RESOURCE_ID, TITLE, DESCRIPTION, CREATION_DATE, DUE_DATE) VALUES
  (1, 'créer un répertoir', 'toto', '2018-07-02 15:47:00', '2018-07-02 16:47:00'),
  (2, 'rennomer le répertoire du projet', 'tata','2018-07-03 16:47:00', '2018-07-03 17:47:00');
