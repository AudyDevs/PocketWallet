<h1 align="center">Pocket Wallet</h1>

<p align="center">  
  Aplicación que nos permite mantener un control de nuestros gastos diarios y mensuales. Base de datos Room donde podremos seleccionar el tipo de gasto, el importe, la fecha y una pequeña anotación. Podremos filtrar los gastos por año y meses anteriores. También disponemos de un apartado resumen con gráficos por tipo de gasto.
</p>
<p align="center">   
  Aplicicación Android [en Jetpack Compose] basada en la arquitectura MVVM desarrollada con DaggerHilt, StateFlows, ViewModels, Corrutinas, Room y Testing
</p>

## 🛠 Herramientas y librerias
- Basado en lenguaje [Kotlin](https://kotlinlang.org/) con una interfaz en Jetpack Compose
- Arquitectura MVVM (Model-View-ViewModel)
- ViewModel y StateFlow: Nos permite almacenar el estado y realizar cambios de forma reactiva en la interfaz de usuario.
- Lifecycle: Observador de los ciclos de vida de Androrid. Los usamos para recolectar los cambios de estado en el StateFlow para modificar la interfaz del usuario.
- Room: Base de datos local sobre SQLite para permitirnos un acceso fluido, eficiente y seguro.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines): Manejo de tareas asíncronas, usado para no bloquear el hilo principal de la aplicación mientras se espera la respuesta de la consulta.
- [Dagger Hilt](https://dagger.dev/hilt/) para inyección de dependencias.
- Navigation component: Es una parte de la suite de Jetpack que simplifica la implementación de la navegación en las Activities y los Fragments.
- Testing
- Código con Clean Code y Clean Architecture

## 📱 Capturas
| Home Screen | Expense Screen |
|--|--|
| <img src="/previews/HomeScreen.webp" width="245" height="500"> | <img src="/previews/ExpenseScreen.webp" width="245" height="500">

| Add Amount | Date Picker |
|--|--|
| <img src="/previews/AddAmount.webp" width="245" height="500"> | <img src="/previews/DatePicker.webp" width="245" height="500">

## 👇 Descargar 👇
Ir a [Releases](https://github.com/AudyDevs/PocketWallet/releases) para descargar el último APK.
