import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leer;
    leer = new Scanner(System.in);
    Tarea t1=null,t2=null,t3=null;
    int opcion=0,numInt=1,eleccion,atributo;
    String nombre,nuevoNombre;
    LocalDate endDate,nuevaFecha;
    while(opcion!=5)
      {
        menu();
        opcion = controlOpcion();
        //borrarPantalla();
        switch(opcion)
          {
            case 1: /*Crear tarea*/
              {
                if(numInt <=3)
                {
                  System.out.println("Ingrese los siguientes datos:");
                  System.out.print("Nombre de la tarea: ");
                  nombre = leer.nextLine();
                  endDate = controlFecha();
                  switch(numInt)
                    {
                      case 1:
                        t1 = new Tarea(nombre,endDate);
                        break;
                      case 2:
                        t2 = new Tarea(nombre,endDate);
                        break;
                      case 3:
                        t3 = new Tarea(nombre,endDate);
                        break;
                    }
                  numInt++;
                }
                else
                {
                  System.out.println("Se alcanzo el maximo de tareas");
                }
              }
              break;
            case 2:/*Modificar tarea*/
              {
                if(numInt != 1) // Si hay tareas creadas
                {
                  System.out.println("¿Cuál desea modificar?");
                  if(t1 != null)
                  {
                    System.out.println("1. Tarea " + t1.getId());
                  }
                  if(t2 != null)
                  {
                    System.out.println("2. Tarea " + t2.getId());
                  }
                  if(t3 != null)
                  {
                    System.out.println("3. Tarea " + t3.getId());
                  }
                  eleccion = controlEleccion(t1, t2, t3);
              
                  Tarea tareaSeleccionada = null;
              
                  switch(eleccion)
                  {
                    case 1:
                      tareaSeleccionada = t1;
                      break;
                    case 2:
                      tareaSeleccionada = t2;
                      break;
                    case 3:
                      tareaSeleccionada = t3;
                      break;
                  }
              
                  if(tareaSeleccionada != null)
                  {
                    System.out.println("Se modificara la tarea: " + tareaSeleccionada.getId());
                    System.out.println("Que atributo se va a modificar? :");
                    System.out.println("1. Nombre");
                    System.out.println("2. Fecha de Finalización");
                    atributo = controlEleccion(t1, t2, t3);
              
                    switch(atributo)
                    {
                      case 1:
                        System.out.print("Nuevo nombre: ");
                        nuevoNombre = leer.nextLine(); 
                        tareaSeleccionada.nombre = nuevoNombre;
                        System.out.println("Se modifico correctamente");
                        break;
                      case 2:
                        nuevaFecha = controlFecha();
                        tareaSeleccionada.endDate = nuevaFecha;
                        System.out.println("Fecha de finalización modificada ");
                        break;
                    }
                  }
                  else
                  {
                    System.out.println("No se encontro la tarea");
                  }
                }
                else
                {
                  System.out.println("No hay ninguna tarea creada.");
                }
              }
              break;
            case 3:
              {
                if(numInt!=1)
                {
                  if(t1!=null)
                  {
                    System.out.println("TAREA 1");
                    System.out.println("Tarea " + t1.getId());
                    System.out.println("Nombre: " + t1.nombre);
                    System.out.println("Estado: " + t1.completed);
                    System.out.println("Fecha de Inicio: " + t1.startDate);
                    System.out.println("Fecha de Finalización: " + t1.endDate);
                    
                  }
                  if(t2!=null)//esta creada la tarea 2
                  {
                    System.out.println("TAREA 2");
                    System.out.println("Tarea " + t2.getId());
                    System.out.println("Nombre: " + t2.nombre);
                    System.out.println("Estado: " + t2.completed);
                    System.out.println("Fecha de Inicio: " + t2.startDate);
                    System.out.println("Fecha de Finalización: " + t2.endDate);
                  }
                  if(t3!=null)//esta creada la tarea 3
                  {
                    System.out.println("TAREA 3");
                    System.out.println("Tarea " + t3.getId());
                    System.out.println("Nombre: " + t3.nombre);
                    System.out.println("Estado: " + t3.completed);
                    System.out.println("Fecha de Inicio: " + t3.startDate);
                    System.out.println("Fecha de Finalización: " + t3.endDate);
                  }
                }
                else
                {
                  System.out.println("No hay ninguna tarea creada.");
                }
              }
              break;
            case 4:/*Marcar tarea como completada*/
              {
                if(numInt!=1)//si hay tareas creadas
                {
                  if( (t1.completed==true) && (t2.completed==true) && (t3.completed==true) )
                  {
                   System.out.println("Se completaron las tareas"); 
                  }
                  else
                  {
                    System.out.println("¿Cuál tarea quiere completar?");
                    if(t1!=null && t1.completed==false)
                    {
                      System.out.print("  (1)  ");
                    }
                    if(t2!=null && t2.completed==false)
                    {
                      System.out.print("  (2)  ");
                    }
                    if(t3!=null && t3.completed==false)
                    {
                      System.out.print("  (3)  ");
                    }
                    System.out.println("");
                    eleccion = controlEleccion(t1,t2,t3);
                    if(t1!=null && eleccion==1)
                    {
                      t1.completed = true;
                    }
                    if(t2!=null && eleccion==2)
                    {
                      t2.completed = true;
                    }
                    if(t2!=null && eleccion==2)
                    {
                      t2.completed = true;
                    }
                    System.out.println("La tarea "+ eleccion + " fue completada!");
                  }
                }
                else
                {
                  System.out.println("No hay ninguna tarea creada.");
                }
              }
              break;
          }
        pause();
        borrarPantalla();
      }
   
  }
  
  public static void menu()
  {
    
    System.out.println("");
    System.out.println("MENÚ");
 
    System.out.println("**************************");
    System.out.println(" 1. Crear nueva tarea");
    System.out.println(" 2. Modificar tarea");
    System.out.println(" 3. Mostrar tareas");
    System.out.println(" 4. Marcar como completada");
    System.out.println(" 5. Salir");
    System.out.println("**************************");
   
    System.out.println("");
  }
  
  public static void borrarPantalla()
  {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  
  public static void pause()
  {
    Scanner leer;
    leer = new Scanner(System.in);
    System.out.println("Presione cualquier tecla para continuar...");
    leer.nextLine();
  }
  
  public static int controlOpcion()
  {
    Scanner leer;
    leer = new Scanner(System.in);
    int opcion = 0;
    boolean opcionValida=false;
    String input;
    while(!opcionValida)
      {
        System.out.println("Ingrese la opción deseada: ");
        input = leer.nextLine();
        try
          {
            opcion = Integer.parseInt(input);
            if(opcion>=1 && opcion<=5)
            {
              opcionValida=true;
            }
            else
            {
              System.out.println("Opcion no valida, Ingrese un valor entre 1 y 4.");
            }
          }
        catch(Exception e)
          {
            System.out.println("Debe ingresar un valor numérico");
          }
      }
    return opcion;
  }

  public static LocalDate controlFecha()
  {
    Scanner leer;
    leer = new Scanner(System.in);
    String dateString;
    boolean validDate = false;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate date = null;
    
    while (!validDate) 
    {
      try 
        {
          System.out.print("Ingrese fecha de inicio (formato: dd-MM-yyyy): ");
          dateString = leer.nextLine();
          date = LocalDate.parse(dateString, dateFormatter);
  
          if (date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now()))
            {
              validDate = true;
            }
          else
            {
              System.out.println("La fecha ingresada debe ser posterior a la fecha actual o de la fecha actual.");
            }
        }
      catch (DateTimeParseException e)
        {
        System.out.println("La fecha ingresada no tiene el formato correcto.");
        }
    }
  return date;
  }

  public static int controlEleccion(Tarea t1, Tarea t2, Tarea t3)
  {
    Scanner leer;
    leer = new Scanner(System.in);
    int eleccion = 0;
    boolean eleccionValida=false;
    String input;
    while(!eleccionValida)
      {
        System.out.println("Ingrese la opción deseada: ");
        input = leer.nextLine();
        try
          {
            eleccion = Integer.parseInt(input);
            if((t1.completed==false && eleccion==1) || (t2.completed==false && eleccion==2) || (t3.completed==false && eleccion==3))
            {
              eleccionValida=true;
            }
            else
            {
              System.out.println("Opcion Incorrecta! Ingrese un valor entre 1 y 3.");
            }
          }
        catch(Exception e)
          {
            System.out.println("Debe ingresar un valor numérico");
          }
      }
    return eleccion;
    }
}