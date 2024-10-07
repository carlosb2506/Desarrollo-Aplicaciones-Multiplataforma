// See https://aka.ms/new-console-template for more information
using Ejercicio1;
using static Ejercicio1.Vehiculo;

Console.WriteLine("Hello, World!");

Vehiculo audi = new Vehiculo("4354 MGF", marca.AUDI, tipo.DEPORTIVO, 6, 114349.98, true, true, 6);
Vehiculo toyota = new Vehiculo("4354 HYF", marca.TOYOTA, tipo.TODOTERRENO, 3, 12456.99, false, true, 2);
Vehiculo alfaromeo = new Vehiculo("4354 LFD", marca.ALFAROMEO, tipo.SEDAN, 5, 34654.96, true, false, 5);

Console.WriteLine(audi.ImporteTotal());
Console.WriteLine(toyota.ImporteTotal());
Console.WriteLine(alfaromeo.ImporteTotal());
