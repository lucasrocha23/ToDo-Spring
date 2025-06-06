
CREATE TABLE Tasks
(
    Id          bigint IDENTITY(1,1) NOT NULL,
    title       nvarchar(100) NOT NULL,
    description nvarchar(500) NULL,
    status      nvarchar(20) NOT NULL,
    created_at  datetime NOT NULL,
    version     bigint   NOT NULL,
);
