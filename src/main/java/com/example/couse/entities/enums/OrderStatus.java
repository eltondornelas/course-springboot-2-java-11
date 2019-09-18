package com.example.couse.entities.enums;

public enum OrderStatus {
	/* poderia ser dessa forma, mas em termos de manutenção não é bom, caso no futuro alguém adicione no meio um outro status por exemplo
	WAITING_PAYMENT,
	PAID,
	SHIPPED,
	DELIVERED,
	CANCELED;
	*/
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
