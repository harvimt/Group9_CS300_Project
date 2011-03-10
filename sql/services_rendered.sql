--
-- TABLE: services_rendered
--
--

CREATE TABLE IF NOT EXISTS services_rendered (
	transaction_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	service_logged INTEGER NOT NULL DEFAULT (date('now')), --datetime
	service_provided INTEGER NOT NULL, --date
	provider_id INTEGER NOT NULL REFERENCES providers,
	service_id INTEGER NOT NULL REFERENCES services,
	member_id INTEGER NOT NULL REFERENCES members,
	comments VARCHAR(100) NOT NULL,
	fee VARCHAR(20) NOT NULL  DEFAULT 0

	CHECK (length(comments) <= 100),
	CHECK (fee REGEXP '[0-9]{1,10}(\.[0-9]*)?')
);
