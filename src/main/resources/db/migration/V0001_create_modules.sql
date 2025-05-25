CREATE TABLE modules (
     id SERIAL PRIMARY KEY,
     name_ru VARCHAR(255) NOT NULL,
     name_kz VARCHAR(255) NOT NULL,
     description_ru TEXT,
     description_kz TEXT,
     is_deleted BOOLEAN DEFAULT FALSE,
     created_at TIMESTAMP DEFAULT now(),
     updated_at TIMESTAMP DEFAULT now()
);