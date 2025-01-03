INSERT INTO utilizatori (nume, utilizator, parola, rolul) VALUES
    ('Raluca Paraschiv', 'ralucaparaschiv', '$2a$12$LQqhOeZZw2hXS6BjuRD/mezHr6Z14u/92riRRM5ZAsQAx51s/4Rnu', 'ROLE_USER'); -- parola: 'parola123'


INSERT INTO utilizatori (nume, utilizator, parola, rolul) VALUES
    ('Maria Avadanei', 'mariavadanei', '$2a$12$GKSxmci.48tlQ388r6ID0.3zO1oEwtSXcVC.vUs2jSjSUzS6lpx9O', 'ROLE_EDITOR'); -- parola: 'editor123'


    INSERT INTO masini (
    nr_inmatriculare, id_utilizator, marca, modelul, culoarea,
    an, capacitate_cilindrica, combustibil,
    putere, cuplu, volum, pret
) VALUES
    ('AB-123-XYZ', 1, 'Toyota', 'Corolla', 'Alb', 2020, 1798, 'Benzina', 140, 180, 450, 20000.00),
    ('BC-456-UVW', 2, 'Volkswagen', 'Golf', 'Negru', 2019, 1984, 'Diesel', 150, 300, 380, 22000.00),
    ('CD-789-RST', 1, 'Ford', 'Focus', 'Rosu', 2021, 1499, 'Hibrid', 120, 200, 370, 25000.00),
    ('DE-101-OPQ', 2, 'BMW', 'X5', 'Albastru', 2018, 2993, 'Diesel', 250, 560, 650, 55000.00),
    ('EF-202-NML', 1, 'Audi', 'A4', 'Gri', 2022, 1984, 'Benzina', 190, 320, 460, 45000.00);