CREATE TABLE delivery (
	
    id BIGINT NOT NULL AUTO_INCREMENT,
    client_id BIGINT NOT NULL,
	status VARCHAR(20) NOT NULL,
    fee DECIMAL(10,2) NOT NULL,
    order_date DATETIME NOT NULL,
    finalization_date DATETIME,
    
	destination_name VARCHAR(60) NOT NULL,
    destination_patio VARCHAR(255) NOT NULL, 
    destination_number VARCHAR(30) NOT NULL,
    destination_complement VARCHAR(60) NOT NULL,
    destination_neighborhood VARCHAR(30) NOT NULL,
    
	PRIMARY KEY (id)
    
);

ALTER TABLE delivery ADD CONSTRAINT fk_delivery_client FOREIGN KEY (client_id) REFERENCES client (id);

