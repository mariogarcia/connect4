# Connect4

Este proyecto es una implementacion del juego del Conecta-4. El codigo ha sido creado y posteriormente
evolucionado en diferentes fases:

- **Fase inicial**: ceacion de las abstracciones que intentaran representaran el dominio del problema. Todavia
en un estado primitivo, no se cumplian principios como open/close ya que por ejemplo
los datos y su representacion estaban acoplados, y esto hacia que hubiera poca cohesion
entre las clases. No obstante si se procuraba encapsular las funcionalidades en cada una de las abstraciones para
poder ser llamadas por otras clases a modo de caja negra (e.g La clase Turn le pregunta al Board si ya hay conecta-4).

- **Creacion de las vistas**: se intenta aplicar mejor el principio open/close con la aplicacion
del patron de vista separada. Se podian visualizar jerarquias mejor definidas para el dominio y las vistas. Ahora
se puede extender/modificar la forma en la que se muestran los datos sin modificar el dominio.
  
- **Fase MVC**: Una vez generadas las vistas se ha ido un paso mas alla para quitar la responsabilidad 
  de conocer el negocio a las vistas y delegarlo en los controladores, reduciendo el acoplamiento entre vista
  y dominio. Esto de nuevo mejora la cohesion en las vistas. No obstante
  
- **Fase MVC(double-dispatching)**: Haciendo uso de la tecnica del doble despacho, volvemos a 
  aplicar el principio open/close haciendo que sea mas facil agregar nuevos controladores sin
  complicar el codigo de la clase Logic. El polimorfismo es una pieza clave en la aplicacion de esta
  tecnica.

- **Todas las fases**: En cada evolutivo se han eliminado **clases perezosas**, o bien porque se ha descubierto que
su responsabilidad estaba tambien incluida en otra, o bien porque al evolucionar el codigo
eran redundantes. Tambien se han eliminado abstracciones innecesarias, sobre todo YAGNI, ya que por ejemplo se crearon
abstracciones para poder utilizar otro tipo de tecnologias de vistas, pero pense que no estaba seguro
de que fuera a llegar a implementarlo por lo que decidi no incluir esa posibilidad hasta que no fuera
una realidad. Tambien me he dado cuenta de que tenia **herencia rechazada** en algunos sitios como en la clase
  abstracta Controller, tenia un metodo que solo se usaba por dos de sus clases hijas y lo que 
  hice fue crear una clase abstracta intermedia solo para esos dos casos.