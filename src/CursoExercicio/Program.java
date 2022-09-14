package CursoExercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<>();
		
		System.out.print("Quantos funcionarios : ");
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			
			System.out.println();
			System.out.print("Id : ");
			Integer id = sc.nextInt();
			while(hasId(list,id)) {
				System.out.println("Esse Id já exixte! Digite outro : ");
				id = sc.nextInt();
			}
			System.out.print("Nome : ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario : ");
			Double salario = sc.nextDouble();
			
			Funcionario func = new Funcionario(id,nome,salario);
			list.add(func);
		}
		
		System.out.println();
		System.out.print("Digite o id do funcionario : ");
		int id = sc.nextInt();
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		System.out.println();
		if(func == null) {
			System.out.println("Esse id não existe");
		}else {
			System.out.print("Digite a porcentagem : ");
			double add = sc.nextDouble();
			func.aumento(add);
		}
		
		System.out.println();
		for (Funcionario x : list) {
		 System.out.println(x);
		}
		
		sc.close();
		
			
	}
	
	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return func != null;
	}
		

}
