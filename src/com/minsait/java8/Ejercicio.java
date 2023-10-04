package com.minsait.java8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ejercicio {

	public static void main(String[] args) {
		/**
		 * Dada la clase persona, crear una interfaz funcional de cada tipo
		 * utilizando referencia de metodos en los casos que aplique
		 * 
		 * Para cada interfaz funcional, al menos un parametro de tipo persona
		 *  
		 */
		Persona persona = new Persona();
		
		persona.setApellido("prueba");
		persona.setNombre("pruebas");
		persona.setEdad(20);

		Persona persona2 = new Persona();
		persona2.setApellido("prueba");
		persona2.setNombre("pruebas");
		persona2.setEdad(20);
		// predicate por lamda
		Predicate<Persona> esMayor = p->p.getEdad() >= 18;
		System.out.println(esMayor.test(persona));
		
		//predicate por referencia no se puede
		Predicate<Persona> esMayor2 = Persona::esMayor;
		System.out.println(esMayor2.test(persona));
		
		// Funcion por lamnda
		Function<Persona, String> nombreCompleto = p->p.getNombre() + " " + p.getApellido();
		System.out.println(nombreCompleto.apply(persona));
		// Funcion por referencia de método
		Function<Persona, String> nombre = Persona::getNombre;
		System.out.println(nombre.apply(persona));
		
		//Consumer por lamnda
		Consumer<Persona> consumer = p->p.imprime();
		consumer.accept(persona);
		//Consumer por referencia
		Consumer<Persona> consumer2 = Persona::imprime;
		consumer2.accept(persona);
		
		//Supplier por lamnda
		Supplier<String> supplier = ()->persona.getNombre();
		System.out.println(supplier.get());
		
		//Supplier por referencia
		/*Supplier<Integer> supplier2 = Persona::getEdad;
		System.out.println(supplier2.get());*/
		
		BiPredicate<Persona, Persona> equal = (p1, p2)->p1.getNombre().equals(p2.getNombre());
		if (equal.test(persona, persona2)){
			System.out.println("Son iguales");
		}
		BiFunction<Persona, Persona, Boolean> equal2 = (p1, p2)->p1.getNombre().equals(p2.getNombre());
		if (equal2.apply(persona, persona2)){
			System.out.println("Son iguales");
		}
		
		BiConsumer<Persona, Persona> biConsumer=(p1, p2)->{p1.imprime(); p2.imprime();}; 
		biConsumer.accept(persona, persona2);
	}

}
