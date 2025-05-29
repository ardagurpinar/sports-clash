-- src/main/resources/db/migration/V1_3__change_winner_id_to_uuid.sql

BEGIN;

-- 1. Drop existing FK constraint (replace with your actual constraint name if different)
ALTER TABLE games
DROP CONSTRAINT IF EXISTS fk_games_winner_id;

-- 2. Alter the column type
--    If the column was numeric, this uses text as an intermediate to UUID;
--    if it was already text, you can drop the ::text cast.
ALTER TABLE games
ALTER COLUMN winner_id
    TYPE uuid
    USING winner_id::text::uuid;

-- 3. Re-add the FK constraint
ALTER TABLE games
    ADD CONSTRAINT fk_games_winner_id
        FOREIGN KEY (winner_id)
            REFERENCES users(id);

COMMIT;
