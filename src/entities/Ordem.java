package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.Order_Status;

public class Ordem {
	
	private Date momento;
	private Order_Status status;
	
	private List<OrdemItem> itens = new ArrayList<>();
}
