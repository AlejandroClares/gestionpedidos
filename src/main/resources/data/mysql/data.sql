INSERT INTO SECUENCIAS VALUES
('LINEAS_PEDIDO_SEQ',1000),
('PEDIDO_SEQ',1000);

INSERT INTO CAMAREROS VALUES
(100,'Pepín Gálvez Ridruejo'),
(101,'Honorio Martín Salvador'),
(102,'Anna Vílchez Andrés');

INSERT INTO PRODUCTOS VALUES
(1,'café solo', 1.20, 'Descripción Producto A','2015-10-20 00:00:00',false,'CAFE'),
(2,'café con leche', 1.40, 'Descripción Producto B','2015-10-20 00:00:00',false,'CAFE'),
(3,'café cortado', 1.30, 'Descripción Producto C','2015-10-20 00:00:00',false,'CAFE'),
(4,'plato combinado', 8.00, 'Descripción Producto D','2015-10-20 00:00:00',false,'COMIDA');

INSERT INTO PEDIDOS VALUES
(1,'2018-10-20 00:00:00',10,100),
(2,'2018-10-20 00:00:00',10,101);


INSERT INTO LINEAS_PEDIDO (ID,ID_PEDIDO,ID_PRODUCTO,INDICE,CANTIDAD,PRECIO) VALUES
(1,1,1,0,1,1.20),
(2,1,2,1,1,1.40),
(3,1,4,2,3,8.00),
(4,2,1,0,1,1.20),
(5,2,3,1,1,1.30);


/*
INSERT INTO LINEAS_PEDIDO (ID,ID_PEDIDO,ID_PRODUCTO,CANTIDAD,PRECIO) VALUES
(1,1,1,0,1.20),
(2,1,2,1,1.40),
(3,1,4,3,8.00),
(4,2,1,1,1.20),
(5,2,3,1,1.30);
*/

