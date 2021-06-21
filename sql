--------------------------------------------------------
-- Archivo creado  - domingo-junio-20-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PEDIDOS_FRUTA
--------------------------------------------------------

  CREATE TABLE "EXAMEN"."PEDIDOS_FRUTA" 
   (	"ID" NUMBER, 
	"CLAVE" NUMBER, 
	"NOMBRE" VARCHAR2(200 BYTE), 
	"ESTATUS" NUMBER, 
	"FECHA_MODIFICACION" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into EXAMEN.PEDIDOS_FRUTA
SET DEFINE OFF;
Insert into EXAMEN.PEDIDOS_FRUTA (ID,CLAVE,NOMBRE,ESTATUS,FECHA_MODIFICACION) values (1,2,'maruchan',1,to_date('18/06/21','DD/MM/RR'));
Insert into EXAMEN.PEDIDOS_FRUTA (ID,CLAVE,NOMBRE,ESTATUS,FECHA_MODIFICACION) values (2,1,'guayaba',1,to_date('20/06/21','DD/MM/RR'));
Insert into EXAMEN.PEDIDOS_FRUTA (ID,CLAVE,NOMBRE,ESTATUS,FECHA_MODIFICACION) values (3,1,'jicama',1,to_date('17/06/21','DD/MM/RR'));
Insert into EXAMEN.PEDIDOS_FRUTA (ID,CLAVE,NOMBRE,ESTATUS,FECHA_MODIFICACION) values (4,1,'seactualizo',1,to_date('17/06/21','DD/MM/RR'));
Insert into EXAMEN.PEDIDOS_FRUTA (ID,CLAVE,NOMBRE,ESTATUS,FECHA_MODIFICACION) values (5,2222,'platano',1,to_date('11/06/21','DD/MM/RR'));
Insert into EXAMEN.PEDIDOS_FRUTA (ID,CLAVE,NOMBRE,ESTATUS,FECHA_MODIFICACION) values (6,3333,'naranja',1,to_date('11/06/21','DD/MM/RR'));
Insert into EXAMEN.PEDIDOS_FRUTA (ID,CLAVE,NOMBRE,ESTATUS,FECHA_MODIFICACION) values (7,1,'seactualizo',1,to_date('17/06/21','DD/MM/RR'));
--------------------------------------------------------
--  DDL for Trigger AUTOINCREMENTAL
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "EXAMEN"."AUTOINCREMENTAL" 
   before insert on "EXAMEN"."PEDIDOS_FRUTA" 
   for each row 
begin  
   if inserting then 
      if :NEW."ID" is null then 
         select PEDIDOSFRUTA.nextval into :NEW."ID" from dual; 
      end if; 
   end if; 
end;

/
ALTER TRIGGER "EXAMEN"."AUTOINCREMENTAL" ENABLE;
--------------------------------------------------------
--  Constraints for Table PEDIDOS_FRUTA
--------------------------------------------------------

  ALTER TABLE "EXAMEN"."PEDIDOS_FRUTA" MODIFY ("ID" NOT NULL ENABLE);
