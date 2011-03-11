--
-- TABLE: providers
--
--

CREATE TABLE IF NOT EXISTS providers (
	provider_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	provider_name VARCHAR(32) NOT NULL ,
	email VARCHAR(128) NOT NULL

	CHECK (provider_id <= 999999999),
	CHECK (length(provider_name) <= 32),
	CHECK (length(email) <= 128),
	CHECK (valid_email(email))
);

CREATE INDEX IF NOT EXISTS providers_provider_name_index ON providers(provider_name);