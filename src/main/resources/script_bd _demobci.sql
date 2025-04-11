
CREATE DATABASE DemoBCI;

USE DemoBCI;


CREATE TABLE Usuarios(

uuid varchar PRIMARY KEY,
nombre varchar
email  varchar
password varchar
fecha_creacion datetime
fecha_modificacion datetime
ultimo_login datetime
token varchar
isActive boolean
);


CREATE TABLE Telefonos(

id_telefono integer NOT NULL PRIMARY KEY,
cityCode integer
contryCode integer
uuid_usuario varchar
CONSTRAINT FK_Usuarios FOREIGN KEY (uuid_usuario)
    REFERENCES Usuarios(uuid)
);
