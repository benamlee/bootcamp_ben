-- CREATE DATABASE EXERCISE4;
USE EXERCISE4;

CREATE TABLE PLAYERS (
	PLAYER_ID INTEGER NOT NULL UNIQUE,
    GROUP_ID INTEGER NOT NULL
);

CREATE TABLE MATCHES (
	MATCH_ID INTEGER NOT NULL UNIQUE,
    FIRST_PLAYER INTEGER NOT NULL,
    SECOND_PLAYER INTEGER NOT NULL,
    FIRST_SCORE INTEGER NOT NULL,
    SECOND_SCORE INTEGER NOT NULL
);

delete from players;
delete from matches;
insert into players values (20, 2);
insert into players values (30, 1);
insert into players values (40, 3);
insert into players values (45, 1);
insert into players values (50, 2);
insert into players values (65, 1);
insert into matches values (1, 30, 45, 10, 12);
insert into matches values (2, 20, 50, 5, 5);
insert into matches values (13, 65, 45, 10, 10);
insert into matches values (5, 30, 65, 3, 15);
insert into matches values (42, 45, 65, 8, 4);

SELECT * FROM PLAYERS;
SELECT * FROM MATCHES;

SELECT 
-- *
-- P.PLAYER_ID, (AVG(M1.FIRST_SCORE) + SUM(M2.SECOND_SCORE)) AS SCORE
P.PLAYER_ID, SUM(M2.SECOND_SCORE) AS SCORE
-- P.PLAYER_ID, M1.SECOND_SCORE AS SCORE
FROM PLAYERS P 
LEFT JOIN MATCHES M1 
ON M1.FIRST_PLAYER = P.PLAYER_ID 
LEFT JOIN MATCHES M2
ON M2.SECOND_PLAYER = P.PLAYER_ID
GROUP BY P.PLAYER_ID
;

SELECT *
FROM PLAYERS P 
LEFT JOIN MATCHES M1 
ON M1.FIRST_PLAYER = P.PLAYER_ID 
LEFT JOIN MATCHES M2
ON M2.SECOND_PLAYER = P.PLAYER_ID
;

-- me
WITH FF AS (
WITH TT AS (
WITH SCORE AS (
WITH TEMP AS (
SELECT P.PLAYER_ID, M1.FIRST_SCORE AS SCORE
FROM PLAYERS P 
LEFT JOIN MATCHES M1 
ON M1.FIRST_PLAYER = P.PLAYER_ID
UNION ALL
SELECT P.PLAYER_ID, M2.SECOND_SCORE AS SCORE
FROM PLAYERS P 
LEFT JOIN MATCHES M2
ON M2.SECOND_PLAYER = P.PLAYER_ID)

SELECT PLAYER_ID, SUM(SCORE) AS SS
FROM TEMP
GROUP BY PLAYER_ID)

SELECT P3.GROUP_ID, S3.PLAYER_ID, (CASE WHEN S3.SS IS NULL THEN 0 ELSE S3.SS END) SS
FROM PLAYERS P3, SCORE S3
WHERE P3.PLAYER_ID = S3.PLAYER_ID)

SELECT ROW_NUMBER() OVER (PARTITION BY TT.GROUP_ID ORDER BY TT.SS DESC, TT.PLAYER_ID) AS R, TT.GROUP_ID, TT.PLAYER_ID, TT.SS
FROM TT)

SELECT FF.GROUP_ID, FF.PLAYER_ID
FROM FF
WHERE FF.R = 1
;


-- 秋秋
-- STEP 1 -- 有哂所有, => each row from t1, show all row in t2
SELECT * FROM PLAYERS P, MATCHES M;
-- STEP 2 -- for each row from t1, collect info needed from t2
SELECT
P.PLAYER_ID, P.GROUP_ID, 
SUM(CASE 
	WHEN PLAYER_ID = FIRST_PLAYER THEN FIRST_SCORE
	WHEN PLAYER_ID = SECOND_PLAYER THEN SECOND_SCORE
    ELSE 0
    END) AS SCORE
FROM PLAYERS P, MATCHES M
GROUP BY PLAYER_ID
;
-- STEP 3 -- partition by
WITH total_score as (
SELECT p.player_id, 
SUM(CASE
		WHEN p.player_id = m.first_player THEN first_score
        WHEN p.player_id = m.second_player THEN second_score
        ELSE 0
	END) as total_score
FROM players p, matches m
GROUP BY p.player_id),

player_score as (
SELECT p.group_id, p.player_id, 
RANK() OVER (PARTITION BY p.group_id ORDER BY t.total_score DESC, p.player_id ASC) AS player_rank
FROM players p LEFT JOIN total_score t 
on p.player_id = t.player_id
ORDER BY p.group_id)

SELECT group_id, player_id
FROM player_score
WHERE player_rank = 1
ORDER BY group_id;