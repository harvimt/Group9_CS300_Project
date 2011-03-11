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
	CHECK (email REGEXP 
		'[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?'
		)
	')
);

CREATE INDEX IF NOT EXISTS providers_provider_name_index ON providers(provider_name);
