-- Migración V2: Añadir columna fecha_registro a las tablas dispositivo_celsius y dispositivo_fahrenheit

ALTER TABLE adapter.dispositivo_celsius
    ADD COLUMN IF NOT EXISTS fecha_registro TIMESTAMP WITH TIME ZONE DEFAULT NOW();

ALTER TABLE adapter.dispositivo_fahrenheit
    ADD COLUMN IF NOT EXISTS fecha_registro TIMESTAMP WITH TIME ZONE DEFAULT NOW();