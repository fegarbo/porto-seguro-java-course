DELIMITER $$
DROP PROCEDURE IF EXISTS incluir_prestador;
CREATE PROCEDURE incluir_prestador(incluir_prestador
	IN documento VARCHAR(14),
    IN usuario VARCHAR(20),
    IN nome VARCHAR(45),
	IN email VARCHAR(45),
    IN telefone VARCHAR(20),
    IN senha VARCHAR(32))
BEGIN
	DECLARE exit handler for sqlexception
		BEGIN
			-- ERROR
            ROLLBACK;
		END;
        
	START TRANSACTION;
		INSERT INTO prestadores(DOCUMENTO, USUARIO, NOME, EMAIL, TELEFONE)
			VALUES (documento, usuario, nome, email, telefone);
		
		INSERT INTO usuarios(NOME, SENHA, NIVEL)
			VALUES (documento, senha, 'PREST');
	COMMIT;
END $$

DELIMITER ;