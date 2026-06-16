-- =============================================================
-- Script SQL : Ajout de la colonne client_email à la table conteneurs
-- Base de données : MySQL
-- =============================================================

-- 1. Ajouter la colonne client_email
ALTER TABLE conteneurs
ADD COLUMN client_email VARCHAR(255) DEFAULT NULL;

-- 2. Ajouter un index pour optimiser les requêtes par email client
CREATE INDEX idx_conteneurs_client_email ON conteneurs(client_email);

-- =============================================================
-- (Optionnel) Associer des conteneurs existants à un client
-- UPDATE conteneurs SET client_email = 'client@example.com' WHERE id = 1;
-- =============================================================
