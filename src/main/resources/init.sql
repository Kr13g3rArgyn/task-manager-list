CREATE TABLE IF NOT EXISTS tasks (
                                     id SERIAL PRIMARY KEY,
                                     title VARCHAR(255) NOT NULL,
    description TEXT,
    completed BOOLEAN NOT NULL DEFAULT FALSE
    );

INSERT INTO tasks (title, description, completed) VALUES
                                                      ('First Task', 'This is the first task', false),
                                                      ('Second Task', 'This is the second task', true);

select * from tasks;