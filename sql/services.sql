--
-- TABLE: services
--
--

CREATE TABLE IF NOT EXISTS services (
	service_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	service_name VARCHAR(32) NOT NULL
	CONSTRAINT "Service with that name already exists" UNIQUE,
	fee VARCHAR(20) NOT NULL DEFAULT 0

	CHECK (service_id <= 999999),
	CHECK (length(service_name) <= 32),
	CHECK (trim(service_name) != ''),
	CHECK (fee REGEXP '[0-9]{1,10}(\.[0-9]*)?')
);