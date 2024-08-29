CREATE SCHEMA IF NOT EXISTS bank;

USE bank;

CREATE TABLE IF NOT EXISTS users
(
    user_id     int(11)      not null     AUTO_INCREMENT,
    first_name  varchar(50)  not null,
    middle_name varchar(50)  null,
    last_name   varchar(50)  not null,
    contact     varchar(50) null,
    password    varchar(50)  not null,
    PRIMARY KEY (user_id)
    )ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS  accounts
(
    account_id     int          not null,
    card_type   varchar(10)   not null,
    apply_date  datetime      not null,
    pin_number  LONG          not null,
    balance     LONG          not null,
    user_id     int(11)   not null,
    PRIMARY KEY (account_id)
    )ENGINE = InnoDB;

ALTER TABLE accounts
    ADD CONSTRAINT fk_users_accounts
        FOREIGN KEY (user_id) REFERENCES users(user_id);


CREATE TABLE IF NOT EXISTS transactions
(
    transaction_id      int     AUTO_INCREMENT,
    transaction_type    ENUM('deposit', 'withdraw','transfer'),
    amount              DECIMAL(10,2)    not null,
    timestamp           timestamp   not null,
    account_id          int         not null,
    PRIMARY KEY (transaction_id)
    )ENGINE = InnoDB;

ALTER TABLE transactions
    ADD CONSTRAINT fk_accounts_transactions
        FOREIGN KEY (account_id) REFERENceS accounts(account_id);

INSERT INTO users(
    first_name,
    last_name,
    contact,
    password
)
VALUES('James','Li','0432216586','Lzy'),
      ('Dada', 'Li','13381923819','Ljg'),
      ('Mama', 'Zhu', '131892734981', 'Zyl');

INSERT INTO accounts(
    account_id,
    card_type,
    apply_date,
    pin_number,
    balance,
    user_id
)
VALUES(1391371623,'debit',now(),197412,10000,1),
      (1231234871, 'debit', now(), 1987825, 20000,1),
      (1231231234, 'credit', now(), 123123,0, 1);

INSERT INTO transactions(
    transaction_type,
    amount,
    timestamp,
    account_id
)
VALUES('deposit', 10000, now(),1391371623),
      ('deposit', 20000, now(),1231234871);

UPDATE transactions
SET amount = 5000
WHERE account_id = 1391371623;


UPDATE transactions
SET amount = 10000
WHERE account_id = 1231234871;

SELECT * FROM bank.accounts;


