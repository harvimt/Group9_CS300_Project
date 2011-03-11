--
-- TABLE: members
--
--

CREATE TABLE IF NOT EXISTS members (
	member_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	full_name VARCHAR(25) NOT NULL ,
	member_status  NOT NULL REFERENCES member_statuses,
	street_address VARCHAR(25) NOT NULL ,
	city VARCHAR(14) NOT NULL ,
	state CHAR(2) NOT NULL ,
	zip_code CHAR(5) NOT NULL ,
	email VARCHAR(128) NOT NULL

	CHECK (member_id <= 999999999),
	CHECK (length(full_name) <= 25),
	CHECK (length(street_address) <= 25),
	CHECK (length(city) <= 14),
	CHECK (length(state) IN (0,2)),
	CHECK (length(zip_code) <= 5),
	CHECK (length(email) <= 128),
	CHECK (valid_email(email))
);

CREATE INDEX IF NOT EXISTS members_full_name_index ON members(full_name);
