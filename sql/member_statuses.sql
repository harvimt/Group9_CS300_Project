
--
-- TABLE: member_statuses
-- An enum representing the values "VALID" "SUSPENDED", "BANNED", or "CANCELED".
--  

CREATE TABLE IF NOT EXISTS member_statuses (
  status_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  status_name varchar(10) NOT NULL UNIQUE
);