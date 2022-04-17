--Stations

DROP TABLE IF EXISTS stations;

CREATE TABLE stations (
  id UUID DEFAULT RANDOM_UUID() PRIMARY KEY NOT NULL,
  name VARCHAR(50) NOT NULL,
  active INT NOT NULL
);

INSERT INTO stations (name, active) VALUES
  ('Santa Iria', 1),
  ('Santa Margarida', 1),
  ('Santana-Cartaxo', 1),
  ('Santarém', 1),
  ('Santo Amaro de Oeiras', 1),
  ('Rossio', 1),
  ('Lagos', 1),
  ('Sintra', 1),
  ('Portimao', 1),
  ('Funcheira', 1)
  ;
