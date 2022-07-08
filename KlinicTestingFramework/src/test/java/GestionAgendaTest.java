import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class GestionAgendaTest {
	WebDriver driver;
	int i = 8;

	By UsernameLocator = By.xpath("(//input[@class='dx-texteditor-input'])[1]");
	By PaswordLocator = By.xpath("(//input[@class='dx-texteditor-input'])[2]");
	By Login = By.xpath("//div[@class='dx-button dx-button-default dx-button-mode-contained dx-widget dx-button-has-text']");
	By Validacion = By.xpath("//div[@class='oph-toast-right-text']/p");
	By Validacion2=By.xpath("//div[@class='dx-toast-message']");
	By TarjetaAdministrarAgendaLocator = By.xpath("(//div[@class='cardContent-container'])[22]");
	By CreacionAgenda = By.xpath("((//*[@class='list-content'])/div)[1]");
	By OpcionCrearAgenda = By.xpath("(//*[@class='dx-radiobutton-icon'])[1]");
	By BusquedaLocator = By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[2]");
	By NombreLocator = By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[33]");
	By AceptarLocator = By.xpath("((//*[@class='dx-item-content dx-toolbar-item-content'])/..//div)[44]");
	By OpcionesSucursales = By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[5]");
	By TextoSucursal = By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[4]");
	By OpcionEspecialidades = By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[9]");
	By TextoEspecialidad = By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[7]");
	By FechaInicialLocator = By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[13]");
	By FechaFinalLocator = By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[14]");
	By HoraInicialLocator = By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[15]");
	By HoraFinalLocator = By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[16]");
	By OpTipoAgenda=By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[31]");
	By TexTipoAgenda=By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[22]");
	By OpcionTipoCita = By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[24]");
	By TextoTipoCita = By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[18]");
	By OpcionBox = By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[35]");
	By TextoBox = By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[25]");
	By OpcionModalidad = By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[39]");
	By TextoModalidad = By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[28]");
	By OpcionConvenios = By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[43]");
	By TextoTiempoAtencion = By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[33]");
	By OpcionPrestaciones = By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[51]");
	By TextoPacientesGrupales = By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[33]");
	By BotonAgregar=By.xpath("((//*[@class='dx-item dx-toolbar-item dx-toolbar-button'])/..//div[@class='dx-button-content'])[9]");
	By Botonguardar=By.xpath("((//*[@class='dx-item-content dx-box-item-content'])/..//div[@class='dx-button-content'])[33]");	
	
	//VARIABLES PUBLICACION AGENDA
	By TarjetaAsignacionCitaLocator = By.xpath("(//div[@class='cardContent-container'])[21]");
	By FechaFinal = By.xpath("(//*[@class='dx-texteditor-input-container'])[3]/input");	
	//B�SQUEDA POR NOMBRE DE PROFESIONAL//
	By NombreProfesional = By.xpath("(//*[@class='dx-texteditor-input-container'])[4]/input"); 
	By BotonBuscar = By.xpath("((//*[@class='dx-item-content dx-box-item-content'])/..//div[@class='dx-button-content'])[4]");	
	// BUSQUEDA POR NUMERO DE SOLICITUD
	By NumeroSolicitud = By.xpath("(//*[@class='dx-texteditor-input-container'])[6]/input");
	By PuntosDetalles = By.xpath("(//*[@class='dx-datagrid-adaptive-more'])[1]");
	By BotonPublicar = By.xpath("(//*[@class='dx-button-content'])[10]");
	By BotonPublicarAgenda = By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//div[@class='dx-button-content'])[3]");
	By RadioButtonParcial = By.xpath("(//*[@class='dx-radio-value-container'])[1]");
	By FechaInicialParcial = By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//input[@class='dx-texteditor-input'])[4]");
	By FechaFinalParcial = By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//input[@class='dx-texteditor-input'])[5]");	
	By FechaInicialC = By.xpath("((//*[@class='dx-form dx-widget dx-visibility-change-handler'])/..//input)[2]");
	By FechaFinalC = By.xpath("((//*[@class='dx-form dx-widget dx-visibility-change-handler'])/..//input)[3]");
	
	// VARIABLE PUBLICACI�N AGENDA //
	
	By OpcionPublicarAgenda = By.xpath("(//*[@class='list-content'])/div[4]");
	//VARIABLES DE ASIGNACION AGENDA
	//FormularioHomeSelectTarAsignaCita
		By ModuloAsignaCitas = By.xpath("(//div[@class='cardContent-container'])[17]");
		By ModuloFichaClinica = By.xpath("(//div[@class='cardContent-container'])[1]");
		By SelectFichaTecProcedAmbulatorio = By.xpath("//div[@id='Ambulatorio']");
		By SelectFichaTecProcedAmbulatorioTipoId = By.xpath("(//div[@class='dx-dropdowneditor-icon'])[1]");
		By PageModuloLocator = By.xpath("(//div[@class='cardContent-container'])[1]");
		By PageModuloLocatorModFichaClinica = By.xpath("//div[@class='dx-button dx-button-success dx-button-mode-contained dx-widget dx-button-has-icon dx-button-has-text']");
		By dropdownListTipoProcemiento =By.xpath("//div[@class='list-content']");
		By clickCloseWindows = By.xpath("//a[@id='604564a184b3e48ef08d9e87']/i[3]");
		By clickCloseWindowsComfirm = By.xpath("((//*[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable dx-popup-inherit-height'])/..//div[@class='dx-button-content'])[1]");
		//FormularioGestionarHora
		By SelecBtnTipoDoc = By.xpath ("((//div[@class='dx-button-content'])[1])/div[last( )]");
		By TextoTipoDoc=By.xpath("");
		By SelectTipoDoc= By.xpath ("(//div[@class='dx-item-content dx-list-item-content'])[2]");
		By DigitaNumDoc= By.xpath("(//input[@class='dx-texteditor-input'])[2]");
		By SearchBtnPaciente = By.xpath ("//dx-button[@class='filter-button dx-button dx-button-success dx-button-mode-contained dx-widget dx-button-has-icon dx-button-has-text']");	
		//FormularioProgrmarHoras
		By SelectBtnProgramar=By.xpath("((//div[@class='dx-button-content'])[5])/span");
		By SelectBtnTipoHora= By.xpath("((//div[@class='dx-button-content'])[1])/div");
		By SelectTipoHora =By.xpath ("(//div[@class='dx-scrollview-content']//div[@class='dx-item-content dx-list-item-content'])[2]");
		By SelectDropDownListBtnEspecialidadProgHora=By.xpath("((//div[@class='dx-button-content'])[2])/div");
		By SelectEspecialidadProgHora= By.xpath("(//input[@class='dx-texteditor-input'])[2]"); //ingresar nombre especialidad -para lista larga
		By SelectEspecialidadProgHoraSelecList= By.xpath("(//div[@class='dx-scrollview-content']//div[@class='dx-item-content dx-list-item-content'])[7]");//Tener presente que se selecciona el primero de la lista (comineza en posici�n '7')
		By SelectDropDownListBtnPrestacion=By.xpath("((//div[@class='dx-button-content'])[3])/div");
		By SelectPrestacionSelectList= By.xpath("(//div[@class='dx-scrollview-content']//div[@class='dx-item-content dx-list-item-content'])[last( )]");
		By SelectDropDownListBtnModalidad=By.xpath("((//div[@class='dx-button-content'])[4])/div");
		By SelectModalidadSeletList= By.xpath("(//div[@class='dx-scrollview-content']/..//div[@class='dx-item-content dx-list-item-content'])[12]");
		By SelectDropDownListBtnSucursal=By.xpath("((//div[@class='dx-button-content'])[5])/div");
		By SelectSucursalSeletList=By.xpath("(//div[@class='dx-scrollview-content']/..//div[@class='dx-item-content dx-list-item-content'])[16]");
		By SelectBtnPrograma=By.xpath("((//div[@class='dx-button-content'])[6])/div");
		By SelectBtnActividades=By.xpath("((//div[@class='dx-button-content'])[7])/div");
		By SelectBtnProfesional=By.xpath("//div[@class='dx-texteditor-input-container dx-tag-container dx-native-click']");
		By SelectProfesionalSeletList=By.xpath("(//div[@class='dx-scrollview-content']/..//div[@class='dx-item-content dx-list-item-content'])[17]");
		//Formulario calendario
		By SelectBtnBuscarProgCita=By.xpath("//dx-button[@text='Buscar']");		
		By SelectPopUpValidaCalendar= By.xpath("//div[@class='dx-toast-message']");
		By SelectPopUpValidaComfirmaCita =By.xpath("(//*[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable dx-popup-flex-height'])/..//div[@class='dx-item-content dx-list-item-content']");
		By SelectOpcBox=By.xpath("((//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable dx-popup-flex-height'])/..//div[@class='dx-button-content'])[1]");
		By SelecBox=By.xpath("((//div[@class='dx-scrollable-wrapper'])/..//div[@class='dx-item-content dx-list-item-content'])[1]");
		By BotonHecho=By.xpath("((//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable dx-popup-flex-height'])/..//div[@class='dx-button-content'])[2]");
	
		WebDriverWait TiempoNormaL;
		WebDriverWait TiempoMaximo;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\luisame\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://factoryaut.digitalwaresaas.com.co:8082/Agora/#/login");
	}

	// Login
	@Test(priority = 0)
	public void Login() throws InterruptedException, IOException {
		
		String Usuario = getCellValueSString(18, 1, "Credenciales");
		String Contraseña = getCellValueSString(19, 1, "Credenciales");
		Thread.sleep(3000);		
		driver.findElement(UsernameLocator).click();
		driver.findElement(UsernameLocator).clear();
		driver.findElement(UsernameLocator).sendKeys(Usuario);
		driver.findElement(PaswordLocator).sendKeys(Contraseña);
		Thread.sleep(500);
		driver.findElement(Login).click();
		Thread.sleep(2000);
		Boolean Val = false;
		String Cadena = "";

		try {
			Cadena = driver.findElement(Validacion).getText().strip();
			Val = true;
		} catch (Exception e) {
			Val = false;
		}
		if (Val == true) {
			if (Cadena.equals("Usuario y/o Contraseña inv�lido")) {
				System.out.println("Usuario y/o Contraseña inv�lido");

			} else {
				
				System.out.println("Credenciales correctas");
			}

		}		
		Thread.sleep(8000);
		/*for (int i = 0; i < 6; i++) {
			Thread.sleep(1000);
			driver.findElement(UsernameLocator).click();
			driver.findElement(UsernameLocator).clear();
			driver.findElement(UsernameLocator).sendKeys(Usuario);
			Thread.sleep(500);
			driver.findElement(PaswordLocator).click();
			driver.findElement(PaswordLocator).clear();
			driver.findElement(PaswordLocator).sendKeys(Contraseña);
			Thread.sleep(1000);
			driver.findElement(Login).click();
			Thread.sleep(2000);
			Boolean Val = false;
			String Cadena = "";

			try {
				Cadena = driver.findElement(Validacion).getText().strip();
				Val = true;
			} catch (Exception e) {
				Val = false;
			}
			if (Val == true) {
				if (Cadena.equals("Usuario y/o Contraseña inv�lido")) {
					System.out.println("Usuario y/o Contraseña inv�lido");

				} else {

					System.out.println("Credenciales correctas");
				}

			}
			
			Thread.sleep(2500);
		}*/
	}

	// Ingreso al modulo Creacion Agenda
	//@Test(priority = 1)
	public void IngresoModuloCreacionAgenda() throws InterruptedException, IOException {
		TiempoNormaL = new WebDriverWait(driver, 10);
		TiempoMaximo = new WebDriverWait(driver, 80);
		Thread.sleep(10000);
		TiempoNormaL.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='cardContent-container'])[1]")));
		WebElement element = driver.findElement(TarjetaAdministrarAgendaLocator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		TiempoNormaL.until(ExpectedConditions.elementToBeClickable(TarjetaAdministrarAgendaLocator));
		driver.findElement(TarjetaAdministrarAgendaLocator).click();
		Thread.sleep(8000);
		driver.switchTo().frame(0);
		TiempoMaximo.until(ExpectedConditions.elementToBeClickable(CreacionAgenda));
		Thread.sleep(5000);
		driver.findElement(CreacionAgenda).click();
		Thread.sleep(15000);
	}

	// Validacion de informacion del profesional
	//@Test(priority = 2)
	public void ValidacionInformacionDelProfesional() throws InterruptedException, IOException {

		String NombreProfesional = getCellValueSString(i, 0, "CreacionAgenda");
		String NombreSucursal = getCellValueSString(i, 1, "CreacionAgenda");
		String NombreEspecialidad = getCellValueSString(i, 2, "CreacionAgenda");
		String SobreCupo = getCellValueSString(i, 3, "CreacionAgenda");
		new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/oph-root/oph-principal-page/oph-intermedial-page/div[1]/div[2]/div[3]/div/iframe")));
		TiempoMaximo.until(ExpectedConditions.elementToBeClickable(OpcionCrearAgenda));
		Thread.sleep(3000);
		driver.findElement(OpcionCrearAgenda).click();
		TiempoNormaL.until(ExpectedConditions.elementToBeClickable(BusquedaLocator));
		Thread.sleep(2000);
		driver.findElement(BusquedaLocator).click();
		Thread.sleep(3000);
		driver.findElement(NombreLocator).click();
		System.out.println(NombreProfesional);
		Thread.sleep(500);
		if (NombreProfesional.indexOf("_") != -1) {
			NombreProfesional = NombreProfesional.replace("_", " ");
		}
		ValSeleccionProfesional(driver, NombreProfesional);
		ValSeleccion(driver, NombreSucursal, OpcionesSucursales, TextoSucursal, "Sucursal");
		ValSeleccion(driver, NombreEspecialidad, OpcionEspecialidades, TextoEspecialidad, "Especialidad");
		ValSeleccionSobreCupo(driver, SobreCupo);
		Thread.sleep(2000);
	}

	// Validacion Campos Creacion Agenda
	//@Test(priority = 3)
	public void ValidacionCreacionAgenda() throws IOException, InterruptedException {
		String FechaInicial = getCellValueSString(i, 5, "CreacionAgenda");
		String FechaFinal = getCellValueSString(i, 6, "CreacionAgenda");
		String Hora1 = getCellValueSString(i, 15, "CreacionAgenda");
		String Hora2 = getCellValueSString(i, 16, "CreacionAgenda");
		String Box = getCellValueSString(i, 18, "CreacionAgenda");
		String Modalidad = getCellValueSString(i, 19, "CreacionAgenda");
		String TiempoAtencion = "" + getCellValuesInt(i, 26, "CreacionAgenda");
		String SobreCupo = getCellValueSString(i, 3, "CreacionAgenda");
		String Tipocita = getCellValueSString(i, 17, "CreacionAgenda");
		String TipoAgenda = getCellValueSString(i, 7, "CreacionAgenda");
		if ((SobreCupo.equals("NO") && Tipocita.equals("Espont�nea")) || (SobreCupo.equals("NO") 
				&&Tipocita.equals("Medicina general"))|| (SobreCupo.equals("NO") &&Tipocita.equals("Cita especialista"))) {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/oph-root/oph-principal-page/oph-intermedial-page/div[1]/div[2]/div[3]/div/iframe")));			
			Thread.sleep(1500);
			ValSeleccionFechas(driver, FechaInicial, FechaFinal);
			Thread.sleep(1000);						
			ValSeleccionDIAS(driver);
			Thread.sleep(2000);
			ValSeleccionHoras(driver, Hora1, Hora2);			
			Thread.sleep(1000);
			ValSeleccionTipoCita(driver);
			Thread.sleep(2000);
			ValSeleccion(driver, TipoAgenda, OpTipoAgenda, TexTipoAgenda, "Tipo Agenda");
			WebElement element1 = driver.findElement(OpcionTipoCita);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);			
			Thread.sleep(1000);			
			ValSeleccion(driver, Box, OpcionBox, TextoBox,"Box");
			Thread.sleep(1000);
			ValSeleccionModalidad(driver, Modalidad);
			Thread.sleep(1000);
			ValSeleccionConvenio(driver, Modalidad);
			Thread.sleep(1000);
			ValSeleccionPrestaciones(driver);
			Thread.sleep(1000);
			driver.findElement(TextoTiempoAtencion).click();
			Thread.sleep(500);
			driver.findElement(TextoTiempoAtencion).sendKeys(TiempoAtencion);
			Thread.sleep(2000);
			driver.findElement(BotonAgregar).click();
			TiempoMaximo.until(ExpectedConditions.visibilityOfElementLocated(Validacion2));
			Thread.sleep(1000);			
			ValidarGuardado(driver);
			Thread.sleep(2000);
			WebElement element = driver.findElement(Botonguardar);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(Botonguardar).click();
			TiempoMaximo.until(ExpectedConditions.visibilityOfElementLocated(Validacion2));
			Thread.sleep(2000);
			Validacionmensaje(driver);
			Thread.sleep(3000);
		} else if ((SobreCupo.equals("NO") && Tipocita.equals("Encadenadas"))
				|| (SobreCupo.equals("NO") && Tipocita.equals("Junta medica"))
				|| (SobreCupo.equals("NO") && Tipocita.equals("Programas especiales"))) {
			Thread.sleep(1500);
			ValSeleccionFechas(driver, FechaInicial, FechaFinal);
			Thread.sleep(2000);
			ValSeleccionDIAS(driver);
			Thread.sleep(2000);
			ValCampos(driver, Box, Modalidad, TiempoAtencion, Hora1, Hora2,TipoAgenda);
		} else if ((SobreCupo.equals("SI") && Tipocita.equals("Espont�nea"))
				|| (SobreCupo.equals("SI") && Tipocita.equals("Medicina general"))
				|| (SobreCupo.equals("SI") && Tipocita.equals("Cita especialista"))) {
			ValCampos3(driver,FechaInicial,FechaFinal, Box, Modalidad, TiempoAtencion, Hora1, Hora2,TipoAgenda);
		}else if ((SobreCupo.equals("SI") && Tipocita.equals("Encadenadas"))
				|| (SobreCupo.equals("SI") && Tipocita.equals("Junta medica"))
				|| (SobreCupo.equals("SI") && Tipocita.equals("Programas especiales"))) {
			Thread.sleep(1500);
			ValSeleccionFechas(driver, FechaInicial, FechaFinal);
			Thread.sleep(2000);
			ValSeleccion(driver, TipoAgenda, OpTipoAgenda, TexTipoAgenda, "Tipo Agenda");
			Thread.sleep(2000);
			ValSeleccionDIAS(driver);
			Thread.sleep(2000);
			ValCampos(driver, Box, Modalidad, TiempoAtencion, Hora1, Hora2,TipoAgenda);
		}
		
	}	
	// M�TODO PARA PUBLICACI�N AGENDA //	
	//@Test(priority = 4)
		public void IngresoModuloPublicar() throws InterruptedException, IOException {
		    String Fecha = getCellValueSString(i, 6, "CreacionAgenda");
		    String Nombre = getCellValueSString(i, 0, "CreacionAgenda");
			TiempoNormaL = new WebDriverWait(driver, 10);
			TiempoMaximo = new WebDriverWait(driver, 80);
			String Mes = Fecha.split("-")[1];
			String Year = Fecha.split("-")[2];
			String Dia = Fecha.split("-")[0];
			Fecha=Mes+"/"+Dia+"/"+Year;
			Thread.sleep(5000);		
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			TiempoMaximo.until(ExpectedConditions.elementToBeClickable(OpcionPublicarAgenda));
			Thread.sleep(5000);
			driver.findElement(OpcionPublicarAgenda).click();
			Thread.sleep(8000);
			new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/oph-root/oph-principal-page/oph-intermedial-page/div[1]/div[2]/div[3]/div/iframe")));
			TiempoMaximo.until(ExpectedConditions.elementToBeClickable(FechaFinal));
			Thread.sleep(5000);
			driver.findElement(FechaFinal).click();
			Thread.sleep(1000);
			driver.findElement(FechaFinal).clear();
			Thread.sleep(1000);
			driver.findElement(FechaFinal).sendKeys(Fecha);
			Thread.sleep(1000);
			driver.findElement(NombreProfesional).click();
			Thread.sleep(1000);
			driver.findElement(NombreProfesional).sendKeys(Nombre);
			Thread.sleep(1000);
			driver.findElement(BotonBuscar).click();
						
			// VALIDACI�N DE N�MERO DE SOLICITUD DE AGENDA SI NO EXISTE GENERE ERROR //			
			Boolean ValSol = false;
			try {			
				Thread.sleep(2000);
				driver.findElement(PuntosDetalles).click();
				ValSol = true;
			} catch (Exception e) {
				ValSol = false;
			}
			if (ValSol == true) {			 
					System.out.println("La Agenda del Especialista se encontr�");
					Thread.sleep(1000);
					driver.findElement(BotonPublicar).click();
					Thread.sleep(4000);
					new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div/div/div[2]/div/iframe")));
					Thread.sleep(6000);
					WebElement element1 = driver.findElement(By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//div[@class='dx-button-content'])[1]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
					Thread.sleep(2000);				
					// VARIABLE DE SELECCI�N DE OPCI�N (PARCIAL O TOTAL) //										
					String TipoAgenda = getCellValueSString(i, 29, "CreacionAgenda");
					String Fecha1 = getCellValueSString(i, 30, "CreacionAgenda");
					String Fecha2 = getCellValueSString(i, 31, "CreacionAgenda");			
					if (TipoAgenda == "Parcial") {
						driver.findElement(RadioButtonParcial).click();
						Thread.sleep(1000);
						// VALIDADOR PARA IDENTIFICAR EL RANGO ENTRE FECHAS CORRECTO //
						if (Fecha1.equals("") || Fecha2.equals("")) {
							System.out.println("La Fecha Est� Vac�a");
						} else {
							WebElement element2 = driver.findElement(By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//div[@class='dx-button-content'])[1]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
							Thread.sleep(1000);
							driver.findElement(FechaInicialParcial).click();
							Thread.sleep(1000);
							driver.findElement(FechaInicialParcial).sendKeys(Fecha1);
							Thread.sleep(1000);
							driver.findElement(FechaFinalParcial).click();
							Thread.sleep(1000);
							driver.findElement(FechaFinalParcial).sendKeys(Fecha2);
							Thread.sleep(1000);
							driver.findElement(BotonPublicarAgenda).click();
							Thread.sleep(1000);
							System.out.println("T�po de Agenda Parcial Pubicada");
						}
					} else {					
						 driver.findElement(BotonPublicarAgenda).click();
						 Thread.sleep(1000);
						 System.out.println("T�po de Agenda Total Pubicada");
					
					 }
				} else {
					System.out.println("El N�mero de Solicitud No se encontr�");
				}
		}
	
	//InToModuloFichaClinicaMedica
		//Se ingresa a la tarjeta para traer los archivos que contiene las listas desplegables para utilizar en AsignaCita 01-09-2021
	  @Test(priority = 5)
		public void IngresoModuloFichaClinicaMedica() throws InterruptedException, IOException {
			TiempoNormaL = new WebDriverWait(driver, 80);
			TiempoMaximo = new WebDriverWait(driver, 180);
			driver.switchTo().defaultContent();	
			driver.findElement(By.xpath("(//*[@class='home-tab-background-overlay'])/..//i[@class='fas fa-times tab-icon-close']")).click();
			Thread.sleep(3000);
			driver.findElement(clickCloseWindowsComfirm).click();
			Thread.sleep(3000);
			TiempoNormaL.until(ExpectedConditions.elementToBeClickable(PageModuloLocator));
			driver.findElement(ModuloFichaClinica).click();
			Thread.sleep(10000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			TiempoMaximo.until(ExpectedConditions.elementToBeClickable(SelectFichaTecProcedAmbulatorio));
			Thread.sleep(2000);
			driver.findElement(SelectFichaTecProcedAmbulatorio).click();
			Thread.sleep(10000);
			driver.switchTo().frame(0);
			TiempoMaximo.until(ExpectedConditions.elementToBeClickable(SelectFichaTecProcedAmbulatorioTipoId));
			Thread.sleep(2000);
			driver.findElement(SelectFichaTecProcedAmbulatorioTipoId).click();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			driver.findElement(clickCloseWindows).click();
			Thread.sleep(5000);
			driver.findElement(clickCloseWindowsComfirm).click();
			Thread.sleep(7000);
		}   			
	  //InToModuloAsignaCitas

	  	@Test(priority = 6)
	  	public void IngresoModuloAsignacionAgenda() throws InterruptedException, IOException {
	  		TiempoNormaL = new WebDriverWait(driver, 80);
	  		TiempoMaximo = new WebDriverWait(driver, 180);
	  		TiempoNormaL.until(ExpectedConditions.elementToBeClickable(PageModuloLocator));
	  		WebElement element = driver.findElement(TarjetaAsignacionCitaLocator);
	  		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	  		driver.findElement(TarjetaAsignacionCitaLocator).click();		
	  	}	

	  //GestionAsignaCita
	    
	  	@Test (priority = 7)
	  	public void MakeAsignaCita () throws InterruptedException , IOException  {
	  		String NumeroDoc=""+getCellValuesInt(i, 33, "CreacionAgenda");
	  		String TipoDoc=getCellValueSString(i, 32, "CreacionAgenda");
	  		String NombreEspecialidad = getCellValueSString(i, 2, "CreacionAgenda");
	  		TiempoNormaL = new WebDriverWait(driver, 80);
	  		TiempoMaximo = new WebDriverWait(driver, 180);
	  		Thread.sleep(15000);
	  		driver.switchTo().frame(0);
	  		driver.findElement(SelecBtnTipoDoc).click();
	  		Thread.sleep(1000);
	  		WebElement element = driver.findElement(By.xpath("(//div[@class='dx-scrollable-wrapper'])/..//div[contains(text(),'"+TipoDoc+"')]"));
	  		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	  		Thread.sleep(1000);
	  		driver.findElement(By.xpath("(//div[@class='dx-scrollable-wrapper'])/..//div[contains(text(),'"+TipoDoc+"')]")).click();	
	  		Thread.sleep(1000);
	  		driver.findElement(DigitaNumDoc).clear();
	  		driver.findElement(DigitaNumDoc).sendKeys(NumeroDoc); // 
	  		driver.findElement(SearchBtnPaciente).click();
	  		Thread.sleep(5000);
	  		driver.findElement(SelectBtnProgramar).click();
	  		TiempoNormaL = new WebDriverWait(driver, 80);
	  		TiempoMaximo = new WebDriverWait(driver, 180);
	  		Thread.sleep(10000);
	  		driver.switchTo().defaultContent();// Cierra todos los paneles 
	  		driver.switchTo().frame(0);// Ingresa al panel cero 
	  		Thread.sleep(10000);
	  		driver.findElement(SelectBtnTipoHora).click();
	  		driver.findElement(SelectTipoHora).click();	
	  		Thread.sleep(6000);
	  		driver.findElement(SelectDropDownListBtnEspecialidadProgHora).click();
	  		driver.findElement(SelectEspecialidadProgHora).click();
	  		driver.findElement(SelectEspecialidadProgHora).clear();
	  		driver.findElement(SelectEspecialidadProgHora).sendKeys(NombreEspecialidad);
	  		Thread.sleep(6000);
	  		driver.findElement(SelectEspecialidadProgHoraSelecList).click();
	  		Thread.sleep(8000);
	  		driver.findElement(SelectDropDownListBtnPrestacion).click();
	  		Thread.sleep(6000);
	  		driver.findElement(SelectPrestacionSelectList).click();
	  		Thread.sleep(6000);
	  		driver.findElement(SelectDropDownListBtnModalidad).click();
	  		driver.findElement(SelectModalidadSeletList).click();
	  		Thread.sleep(6000);
	  		driver.findElement(SelectDropDownListBtnSucursal).click();
	  		driver.findElement(SelectSucursalSeletList).click();
	  		Thread.sleep(6000);
	  		driver.findElement(SelectBtnProfesional).click();
	  		driver.findElement(SelectProfesionalSeletList).click();
	  		Thread.sleep(6000);
	  		driver.findElement(SelectBtnBuscarProgCita).click();
	  		//valida Actualiza calendario 
	  		String Cadena1 ="";
	  		boolean Val1;
	  		
	  		try {
	  			Thread.sleep(5000);
	  			Cadena1 = driver.findElement(SelectPopUpValidaCalendar).getText().strip();
	  			Val1 = true;
	  		} catch (Exception e) {
	  			Val1 = false;
	  		}
	  		
	  		if (Val1 == true) {
	  			if (Cadena1.equals("Calendario Actualizado")) {
	  				System.out.println("El calendario fue actualizado");
	  				
	  			} else {
	  				System.out.println("Vuelva a presionar bot�n buscar");
	  			}
	  		}
	  		
	  		driver.switchTo().defaultContent();// Cierra todos los paneles 
	  		driver.switchTo().frame(0);// Ingresa al panel cero 
	  		new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/oph-root/oph-appointment-management/div/oph-particular-appointments/div[2]/div[4]/div[1]/iframe")));
	  		Thread.sleep(4000);
	  		WebElement element1 = driver.findElement(By.xpath("((//div[@class='dx-scheduler-view-switcher dx-tabs dx-widget dx-visibility-change-handler dx-collection dx-tabs-expanded'])/div/div)[1]/div"));
	  		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
	  		Thread.sleep(1000);
	  		driver.findElement(By.xpath("((//div[@class='dx-scheduler-view-switcher dx-tabs dx-widget dx-visibility-change-handler dx-collection dx-tabs-expanded'])/div/div)[1]/div")).click();
	  		Thread.sleep(2000);
	  		String FechaCalendario=driver.findElement(By.xpath("((//div[@class='dx-scheduler-header dx-widget']))/..//div[@class='dx-button-content']/span")).getText().strip();
			String Mes = FechaCalendario.split(" ")[1];
			String Year = FechaCalendario.split(" ")[2];
			String Dia = FechaCalendario.split(" ")[0];		
			String FechaCita="20 diciembre 2021";
			String MesCita = FechaCita.split(" ")[1];
			String YearCita = FechaCita.split(" ")[2];
			String DiaCita = FechaCita.split(" ")[0];	
			String Hora="20:00 - 20:30";
			
			while ((!DiaCita.equals(Dia)) || (!MesCita.equals(Mes))|| (!YearCita.equals(Year))) {
				driver.findElement(By.xpath("((//div[@class='dx-scheduler-header dx-widget'])/..//div[@class='dx-button-content'])[3]")).click();
				Thread.sleep(100);
				Mes = FechaCalendario=driver.findElement(By.xpath("((//div[@class='dx-scheduler-header dx-widget']))/..//div[@class='dx-button-content']/span")).getText().strip();
				Mes = FechaCalendario.split(" ")[1];
				Year = FechaCalendario.split(" ")[2];
				Dia = FechaCalendario.split(" ")[0];
			}
			
			boolean veri=false;			
			Thread.sleep(2000);
			try {
				WebElement element2 = driver.findElement(By.xpath("(((//*[@class='dx-scrollable-container'])/..//div[@class='dx-scheduler-scrollable-appointments dx-widget dx-collection'])/div/div/strong)[1]"));
		  		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		  		veri=true;
			}catch (Exception e) {				
				veri=false;
			}
			
	  		Thread.sleep(1000);

	  		if(veri==true) {
	  			List<WebElement> dates = driver.findElements(By.xpath("((//*[@class='dx-scrollable-container'])/..//div[@class='dx-scheduler-scrollable-appointments dx-widget dx-collection'])/div/div/strong"));
	  			int cont=1;
	  			for (WebElement e : dates) {
	  				Thread.sleep(500);
	  				WebElement element2 = driver.findElement(By.xpath("(((//*[@class='dx-scrollable-container'])/..//div[@class='dx-scheduler-scrollable-appointments dx-widget dx-collection'])/div/div/strong)["+cont+"]"));
	  		  		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
	  		  		Thread.sleep(1000);
	  				String Agenda=driver.findElement(By.xpath("(((//*[@class='dx-scrollable-container'])/..//div[@class='dx-scheduler-scrollable-appointments dx-widget dx-collection'])/div/div/strong)["+cont+"]")).getText().strip();
	  				String Horas=Agenda.split(" ")[3]+" - "+Agenda.split(" ")[5];
	  				System.out.println(Horas);
	  				cont++;
	  				if (Hora.equals(Horas)) {
	  					System.out.println("Se encontro agenda disponible en esa fecha y hora");
	  					Thread.sleep(1000);
	  					Actions actions = new Actions(driver);
	  					WebElement elementLocator = driver.findElement(By.xpath("(((//*[@class='dx-scrollable-container'])/..//div[@class='dx-scheduler-scrollable-appointments dx-widget dx-collection'])/div/div)["+cont+"]"));
	  					actions.doubleClick(elementLocator).perform();
	  					Thread.sleep(1000);
	  					Thread.sleep(6000);
	  			  	    driver.findElement(SelectOpcBox).click();
	  			  	    Thread.sleep(6000);
	  			  		driver.findElement(SelecBox).click();
	  			  		Thread.sleep(6000);
	  			  		//driver.findElement(BotonHecho).click();
	  			  		Thread.sleep(5000);  
	  			  	//Valida Asigna cita
	  			  		String Cadena2 ="";
	  			  		boolean Val2;  			  		
	  			  		try {
	  			  			Thread.sleep(5000);
	  			  			Cadena2 = driver.findElement(SelectPopUpValidaComfirmaCita).getText().strip();
	  			  			Val2 = true;
	  			  		} catch (Exception e1) {
	  			  			Val2 = false;
	  			  		}		  		
	  			  		if (Val2 == true) {
	  			  			if (Cadena2.equals("Registro satisfactorio!!")) {
	  			  				System.out.println("El Registro fue satisfactorio!!");
	  			  				
	  			  			}else if(Cadena2.equals("El paciente ya tiene una fecha programada para la fecha indicada.")){
	  			  				 System.out.println("El paciente ya tiene una fecha programada para la fecha indicada.");
	  			  				 
	  			  			}else {
	  			  				System.out.println("El paciente ya tiene una fecha programada para la fecha indicada.");
	  			  			}
	  			  		}	
	  					break;
	  				}else {
	  					System.out.println("No se encontro agenda disponible en esa fecha y hora");
	  				}
	  			}
	  			
	  		}
	  	} 
	  	
	  	
	@AfterClass
	public void afterClass() {
	}
	
	public void ValidarGuardado(WebDriver driver) {
		Boolean Val = false;
		String Cadena = "";
		try {
			Cadena = driver.findElement(Validacion2).getText().strip();
			Val = true;
		} catch (Exception e) {
			Val = false;
		}
		if (Val == true) {
			if (Cadena.contains("Requerido")) {
				System.out.println("No se pudo crear guardar la agenda, un campo obligatorio no fue diligenciado");
			} else if(Cadena.contains("Operaci�n realizada correctamente")) {
				System.out.println("La informacion se guardo correctamente");
			}

		}
	}
	
	
	public void Validacionmensaje(WebDriver driver) {
		Boolean Val = false;
		String Cadena = "";
		try {
			Cadena = driver.findElement(Validacion2).getText().strip();
			Val = true;
		} catch (Exception e) {
			Val = false;
		}
		if (Val == true) {
			if (Cadena.contains("no se puede asignar el")) {
				System.out.println("No se pudo crear la agenda, el consultorio no esta disponible");
			} else if (Cadena.contains("Ocurri� un error consumiendo el servicio")) {
				System.out.println("No se pudo crear la agenda, Ocurri� un error consumiendo el servicio");
			} else if (Cadena.contains("Ya se cuenta con una agenda numero")) {
				System.out.println("No se pudo crear la agenda, Ya se cuenta con una agenda asignada");
			}else if (Cadena.contains("El campo Consultorio no existe en el formulario")) {
				System.out.println("No se pudo crear la agenda, El campo Consultorio no existe en el formulario");
			}else if (Cadena.contains("El par�metro del profesional es incorrecto")) {
				System.out.println("No se pudo crear la agenda, El par�metro del profesional es incorrecto");
			}

		}
	}
	
	public void ValSeleccionProfesional(WebDriver driver, String Nombre) throws InterruptedException {
		boolean seleccion;
		try {
			driver.findElement(NombreLocator).sendKeys(Nombre);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@class='dx-datagrid-content'])[11]/..//td[contains(text(),'" + Nombre + "')]")).click();
			seleccion = true;
		} catch (Exception e) {
			seleccion = false;
		}
		if (seleccion == true) {
			Thread.sleep(1000);
			driver.findElement(AceptarLocator).click();
			Thread.sleep(1000);
			System.out.println("Si existe el profesional");
		} else {
			System.out.print("No existe el profesional");
		}
	}

	public void ValSeleccion(WebDriver driver, String Nombre,By Opcion, By Texto, String Campo)
			throws InterruptedException {
		boolean seleccion;
		try {
			driver.findElement(Opcion).click();
			Thread.sleep(1000);
			driver.findElement(Texto).click();
			Thread.sleep(500);
			driver.findElement(Texto).sendKeys(Nombre);
			Thread.sleep(800);
			driver.findElement(By.xpath("(//*[@class='dx-datagrid-content'])[10]/..//td[contains(text(),'" + Nombre + "')]")).click();
			seleccion = true;
		} catch (Exception e) {
			seleccion = false;
		}
		Thread.sleep(1000);
		if (seleccion == true) {
			Thread.sleep(500);
			System.out.println("Si existe la/el " + Campo);
		} else {
			driver.findElement(Texto).clear();
			Thread.sleep(1000);
			driver.findElement(Opcion).click();
			System.out.println("No existe la/el " + Campo);
		}
	}

	public void ValSeleccionSobreCupo(WebDriver driver, String Nombre) throws InterruptedException {
		if (Nombre.equals("SI") || Nombre.equals("si")) {
			driver.findElement(By.xpath("((//*[@class='dx-switch-container'])[1])/..//div[@class='dx-switch-off']")).click();
			System.out.println("Si hay sobre Cupo");
		} else if (Nombre.equals("NO") || Nombre.equals("no")) {
			driver.findElement(By.xpath("((//*[@class='dx-switch-container'])[1])/..//div[@class='dx-switch-off']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//*[@class='dx-switch-container'])[1])/..//div[@class='dx-switch-on']")).click();
			Thread.sleep(1000);
			System.out.println("No hay Sobre Cupo");
		}
	}

	public void ValSeleccionFechas(WebDriver driver, String fecha1, String fecha2) throws InterruptedException {

		if (fecha1.equals("")) {
			System.out.println("No se ingreso una fecha inicial");
		} else {
			driver.findElement(FechaInicialLocator).click();
			Thread.sleep(500);
			driver.findElement(FechaInicialLocator).sendKeys(fecha1);
		}
		Thread.sleep(500);
		if (fecha2.equals("")) {
			System.out.println("No se ingreso una fecha inicial");
		} else {
			driver.findElement(FechaFinalLocator).click();
			Thread.sleep(500);
			driver.findElement(FechaFinalLocator).sendKeys(fecha2);
		}
	}

	public void ValSeleccionDIAS(WebDriver driver) throws InterruptedException, IOException {
		String Dia1 = getCellValueSString(i, 8, "CreacionAgenda");
		String Dia2 = getCellValueSString(i, 9, "CreacionAgenda");
		String Dia3 = getCellValueSString(i, 10, "CreacionAgenda");
		String Dia4 = getCellValueSString(i, 11, "CreacionAgenda");
		String Dia5 = getCellValueSString(i, 12, "CreacionAgenda");
		String Dia6 = getCellValueSString(i, 13, "CreacionAgenda");
		String Dia7 = getCellValueSString(i, 14, "CreacionAgenda");
		if (Dia1.equals("NO") && Dia2.equals("NO") && Dia3.equals("NO") && Dia4.equals("NO") && Dia5.equals("NO")
				&& Dia6.equals("NO") && Dia7.equals("NO")) {

			System.out.println("No se selecciono ningun dia de la semana");

		} else {
			if (Dia1.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[1]")).click();
			}
			if (Dia2.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[2]")).click();
			}
			if (Dia3.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[3]")).click();
			}
			if (Dia4.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[4]")).click();
			}
			if (Dia5.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[5]")).click();
			}
			if (Dia6.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[6]")).click();
			}
			if (Dia7.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[7]")).click();
			}
		}

	}

	public void ValSeleccionHoras(WebDriver driver, String Hora1, String Hora2) throws InterruptedException {

		if (Hora1.equals("")) {
			System.out.println("No se ingreso una Hora inicial");
		} else {
			driver.findElement(HoraInicialLocator).click();
			Thread.sleep(1000);
			driver.findElement(HoraInicialLocator).sendKeys(Hora1);
		}
		Thread.sleep(2000);
		if (Hora2.equals("")) {
			System.out.println("No se ingreso una Hora inicial");
		} else {
			driver.findElement(HoraFinalLocator).click();
			Thread.sleep(1000);
			driver.findElement(HoraFinalLocator).sendKeys(Hora2);

		}

	}

	public void ValSeleccionTipoCita(WebDriver driver) throws InterruptedException, IOException {
		String Tipocita = getCellValueSString(i, 17, "CreacionAgenda");

		boolean seleccion;
		try {
			driver.findElement(OpcionTipoCita).click();
			Thread.sleep(2000);
			driver.findElement(TextoTipoCita).click();
			Thread.sleep(3000);
			driver.findElement(TextoTipoCita).sendKeys(Tipocita);
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//*[@class='dx-datagrid-content'])[10]/..//td[contains(text(),'" + Tipocita + "')]")).click();
			seleccion = true;
		} catch (Exception e) {
			seleccion = false;
		}
		Thread.sleep(3000);

		if (seleccion == true) {
			System.out.println("Si existe el tipo de cita");
		} else {
			driver.findElement(TextoTipoCita).clear();
			Thread.sleep(1500);
			driver.findElement(OpcionTipoCita).click();
			System.out.println("No existe el tipo de cita ingresado");
		}

	}

	public void ValCampos(WebDriver driver, String Box, String Modalidad, String TiempoAtencion,String Hora1, String Hora2, String TipoAgenda) throws InterruptedException, IOException {		
		if (Hora1.equals("")) {
			System.out.println("No se ingreso una Hora inicial");
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[15]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[15]")).sendKeys(Hora1);
		}
		Thread.sleep(2000);
		if (Hora2.equals("")) {
			System.out.println("No se ingreso una Hora inicial");
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[16]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[16]")).sendKeys(Hora2);
		}		
		String Tipocita = getCellValueSString(i, 17, "CreacionAgenda");
		boolean seleccion1;
		try {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[26]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[18]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[18]")).sendKeys(Tipocita);
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//*[@class='dx-datagrid-content'])[10]/..//td[contains(text(),'" + Tipocita + "')]")).click();
			seleccion1 = true;
		} catch (Exception e) {
			seleccion1 = false;
		}
		Thread.sleep(3000);

		if (seleccion1 == true) {
			System.out.println("Si existe el tipo de cita");
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[18]")).clear();
			Thread.sleep(1500);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[26]")).click();
			System.out.println("No existe el tipo de cita ingresado");
		}
		
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("((//*[@class='dx-item-content dx-box-item-content'])/..//div[@class='dx-button-content'])[28]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		
		boolean seleccion;
		try {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[30]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[21]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[21]")).sendKeys(TipoAgenda);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@class='dx-datagrid-content'])[10]/..//td[contains(text(),'" + TipoAgenda + "')]")).click();
			seleccion = true;
		} catch (Exception e) {
			seleccion = false;
		}
		Thread.sleep(3000);
		if (seleccion == true) {
			Thread.sleep(2000);
			System.out.println("Si existe la/el " + TipoAgenda);
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[21]")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[30]")).click();
			System.out.println("No existe la/el " + TipoAgenda);
		}
		//Seleccion Box
		boolean seleccion5;
		try {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[34]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[24]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[24]")).sendKeys(Box);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@class='dx-datagrid-content'])[10]/..//td[contains(text(),'" + Box + "')]")).click();
			seleccion5 = true;
		} catch (Exception e) {
			seleccion5 = false;
		}
		Thread.sleep(3000);
		if (seleccion5 == true) {
			System.out.println("Si existe el BOX");
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[24]")).clear();
			Thread.sleep(1500);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[34]")).click();
			System.out.println("No existe el BOX");
		}
		//Seleccion Modalidad
		boolean seleccion4;
		try {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[38]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[3]")).click();
			seleccion4 = true;
		} catch (Exception e) {
			seleccion4 = false;
		}
		Thread.sleep(3000);
		if (seleccion4 == true) {
			System.out.println("Si existe la modalidad Ingresada");
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[38]")).click();
			System.out.println("No existe la modalidad Ingresada");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[@class='dx-item-content dx-toolbar-item-content'])[8]/div/div")).click();
		Thread.sleep(500);
		//Seleccion Convenio
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[42]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[6]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='dx-item-content dx-toolbar-item-content'])[8]/div/div")).click();
		
		//Campo Tiempo de atencion		
		Thread.sleep(500);
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[32]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[32]")).sendKeys(TiempoAtencion);		
		Thread.sleep(1000);
		//Campo Prestaciones
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[50]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[8]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[@class='dx-item-content dx-toolbar-item-content'])[8]/div/div")).click();
		//Campo Pacientes Grupales
		String PacienteGrupales = "" + getCellValuesInt(i, 25, "CreacionAgenda");
		Thread.sleep(1000);
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[37]")).click();
		Thread.sleep(800);
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[37]")).sendKeys(PacienteGrupales);
		Thread.sleep(1000);
		driver.findElement(BotonAgregar).click();
		TiempoMaximo.until(ExpectedConditions.visibilityOfElementLocated(Validacion2));
		Thread.sleep(1000);			
		ValidarGuardado(driver);
		Thread.sleep(2000);
		WebElement element5 = driver.findElement(By.xpath("((//*[@class='dx-item-content dx-box-item-content'])/..//div[@class='dx-button-content'])[33]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element5);
		Thread.sleep(1000);
		driver.findElement(By.xpath("((//*[@class='dx-item-content dx-box-item-content'])/..//div[@class='dx-button-content'])[33]")).click();
		TiempoMaximo.until(ExpectedConditions.visibilityOfElementLocated(Validacion2));
		Thread.sleep(1000);
		Validacionmensaje(driver);
		Thread.sleep(5000);    
	}
	
	public void ValCampos3(WebDriver driver,String fecha1,String fecha2, String Box, String Modalidad, String TiempoAtencion,String Hora1, String Hora2, String TipoAgenda) throws InterruptedException, IOException {		
		if (fecha1.equals("")) {
			System.out.println("No se ingreso una fecha inicial");
		} else {
			driver.findElement(FechaInicialLocator).click();
			Thread.sleep(500);
			driver.findElement(FechaInicialLocator).sendKeys(fecha1);
		}
		Thread.sleep(500);
		if (fecha2.equals("")) {
			System.out.println("No se ingreso una fecha inicial");
		} else {
			driver.findElement(FechaFinalLocator).click();
			Thread.sleep(500);
			driver.findElement(FechaFinalLocator).sendKeys(fecha2);
		}
		String Dia1 = getCellValueSString(i, 8, "CreacionAgenda");
		String Dia2 = getCellValueSString(i, 9, "CreacionAgenda");
		String Dia3 = getCellValueSString(i, 10, "CreacionAgenda");
		String Dia4 = getCellValueSString(i, 11, "CreacionAgenda");
		String Dia5 = getCellValueSString(i, 12, "CreacionAgenda");
		String Dia6 = getCellValueSString(i, 13, "CreacionAgenda");
		String Dia7 = getCellValueSString(i, 14, "CreacionAgenda");
		if (Dia1.equals("NO") && Dia2.equals("NO") && Dia3.equals("NO") && Dia4.equals("NO") && Dia5.equals("NO")
				&& Dia6.equals("NO") && Dia7.equals("NO")) {

			System.out.println("No se selecciono ningun dia de la semana");

		} else {
			if (Dia1.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[1]")).click();
			}
			if (Dia2.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[2]")).click();
			}
			if (Dia3.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[3]")).click();
			}
			if (Dia4.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[4]")).click();
			}
			if (Dia5.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[5]")).click();
			}
			if (Dia6.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[6]")).click();
			}
			if (Dia7.equals("SI")) {
				driver.findElement(By.xpath("(//*[@class='dx-checkbox-container'])[7]")).click();
			}
		}
		if (Hora1.equals("")) {
			System.out.println("No se ingreso una Hora inicial");
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[15]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[15]")).sendKeys(Hora1);
		}
		Thread.sleep(2000);
		if (Hora2.equals("")) {
			System.out.println("No se ingreso una Hora inicial");
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[16]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/input)[16]")).sendKeys(Hora2);
		}		
		String Tipocita = getCellValueSString(i, 17, "CreacionAgenda");
		boolean seleccion1;
		try {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[26]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[18]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[18]")).sendKeys(Tipocita);
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//*[@class='dx-datagrid-content'])[10]/..//td[contains(text(),'" + Tipocita + "')]")).click();
			seleccion1 = true;
		} catch (Exception e) {
			seleccion1 = false;
		}
		Thread.sleep(3000);

		if (seleccion1 == true) {
			System.out.println("Si existe el tipo de cita");
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[18]")).clear();
			Thread.sleep(1500);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[26]")).click();
			System.out.println("No existe el tipo de cita ingresado");
		}
		
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("((//*[@class='dx-item-content dx-box-item-content'])/..//div[@class='dx-button-content'])[28]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		
		boolean seleccion;
		try {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[30]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[21]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[21]")).sendKeys(TipoAgenda);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@class='dx-datagrid-content'])[10]/..//td[contains(text(),'" + TipoAgenda + "')]")).click();
			seleccion = true;
		} catch (Exception e) {
			seleccion = false;
		}
		Thread.sleep(3000);
		if (seleccion == true) {
			Thread.sleep(2000);
			System.out.println("Si existe la/el " + TipoAgenda);
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[21]")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[30]")).click();
			System.out.println("No existe la/el " + TipoAgenda);
		}
		//Seleccion Box
		boolean seleccion5;
		try {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[34]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[24]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[24]")).sendKeys(Box);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@class='dx-datagrid-content'])[10]/..//td[contains(text(),'" + Box + "')]")).click();
			seleccion5 = true;
		} catch (Exception e) {
			seleccion5 = false;
		}
		Thread.sleep(3000);
		if (seleccion5 == true) {
			System.out.println("Si existe el BOX");
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[24]")).clear();
			Thread.sleep(1500);
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[34]")).click();
			System.out.println("No existe el BOX");
		}
		//Seleccion Modalidad
		boolean seleccion4;
		try {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[38]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[3]")).click();
			seleccion4 = true;
		} catch (Exception e) {
			seleccion4 = false;
		}
		Thread.sleep(3000);
		if (seleccion4 == true) {
			System.out.println("Si existe la modalidad Ingresada");
		} else {
			driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[38]")).click();
			System.out.println("No existe la modalidad Ingresada");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[@class='dx-item-content dx-toolbar-item-content'])[8]/div/div")).click();
		Thread.sleep(500);
		//Seleccion Convenio
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[42]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[6]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='dx-item-content dx-toolbar-item-content'])[8]/div/div")).click();
		
		//Campo Tiempo de atencion		
		Thread.sleep(500);
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[32]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[32]")).sendKeys(TiempoAtencion);		
		Thread.sleep(1000);
		//Campo Prestaciones
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-buttons-container'])/div)[50]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[8]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[@class='dx-item-content dx-toolbar-item-content'])[8]/div/div")).click();
		//Campo Pacientes Grupales
		String PacienteGrupales = "" + getCellValuesInt(i, 25, "CreacionAgenda");
		Thread.sleep(1000);
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[37]")).click();
		Thread.sleep(800);
		driver.findElement(By.xpath("((//*[@class='dx-texteditor-input-container'])/..//input)[37]")).sendKeys(PacienteGrupales);
		Thread.sleep(1000);
		driver.findElement(BotonAgregar).click();
		TiempoMaximo.until(ExpectedConditions.visibilityOfElementLocated(Validacion2));
		Thread.sleep(1000);			
		ValidarGuardado(driver);
		Thread.sleep(2000);
		WebElement element5 = driver.findElement(By.xpath("((//*[@class='dx-item-content dx-box-item-content'])/..//div[@class='dx-button-content'])[33]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element5);
		Thread.sleep(1000);
		driver.findElement(By.xpath("((//*[@class='dx-item-content dx-box-item-content'])/..//div[@class='dx-button-content'])[33]")).click();
		TiempoMaximo.until(ExpectedConditions.visibilityOfElementLocated(Validacion2));
		Thread.sleep(1000);
		Validacionmensaje(driver);
		Thread.sleep(5000);    
	}

	public void ValSeleccionBox(WebDriver driver, String Nombre) throws InterruptedException {
		boolean seleccion;
		try {
			driver.findElement(OpcionBox).click();
			Thread.sleep(3000);
			driver.findElement(TextoBox).click();
			Thread.sleep(3000);
			driver.findElement(TextoBox).sendKeys(Nombre);
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[11]")).click();
			seleccion = true;
		} catch (Exception e) {
			seleccion = false;
		}
		Thread.sleep(3000);
		if (seleccion == true) {
			System.out.println("Si existe el BOX");
		} else {
			driver.findElement(TextoBox).clear();
			Thread.sleep(1500);
			driver.findElement(OpcionBox).click();
			System.out.println("No existe el BOX");
		}
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[@class='dx-item-content dx-toolbar-item-content'])[8]/div/div")).click();

	}

	public void ValSeleccionModalidad(WebDriver driver, String Nombre) throws InterruptedException {
		boolean seleccion;
		try {
			driver.findElement(OpcionModalidad).click();
			Thread.sleep(3000);
			if(Nombre.equals("Ambas")) {
				driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[1]/div")).click();
				seleccion = true;
			}else if(Nombre.equals("Telemedicina")) {
				driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[2]/div")).click();
				seleccion = true;
			
			}else {
				driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[3]/div")).click();
				seleccion = true;			
			}							
		} catch (Exception e) {
			seleccion = false;
		}
		Thread.sleep(3000);
		if (seleccion == true) {
			System.out.println("Si existe la modalidad Ingresada");
		} else {
			driver.findElement(TextoModalidad).clear();
			Thread.sleep(1500);
			driver.findElement(OpcionModalidad).click();
			System.out.println("No existe la modalidad Ingresada");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[@class='dx-item-content dx-toolbar-item-content'])[8]/div/div")).click();
	}

	public void ValSeleccionConvenio(WebDriver driver, String Nombre) throws InterruptedException, IOException {
		
		driver.findElement(OpcionConvenios).click();
		Thread.sleep(2000);
		if(Nombre.equals("Ambas")) {
			driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[5]/div")).click();
		}else {
			driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[6]/div")).click();
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[@class='dx-item-content dx-toolbar-item-content'])[8]/div/div")).click();
	}

	public void ValSeleccionPrestaciones(WebDriver driver) throws InterruptedException, IOException {
		int cont = 6;
		//Thread.sleep(1000);
		//String Prestacion1 = getCellValueSString(i, 26, "CreacionAgenda");
		//String Prestacion2 = getCellValueSString(i, 27, "CreacionAgenda");
		//String Prestacion3 = getCellValueSString(i, 28, "CreacionAgenda");
		Thread.sleep(1000);
		driver.findElement(OpcionPrestaciones).click();
		Thread.sleep(2000);
		/*if (Prestacion1.equals("NO") && Prestacion2.equals("NO") && Prestacion3.equals("NO")) {
			driver.findElement(OpcionPrestaciones).click();
			System.out.println("No se selecciono ninguna prestacion");
		} else {
			driver.findElement(TextoPrestaciones).click();
			Thread.sleep(1000);
			driver.findElement(TextoPrestaciones).sendKeys("CONSULTA DE CONTROL");
			Thread.sleep(2000);*/
			driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[8]/div")).click();
			Thread.sleep(1000);
			//driver.findElement(By.xpath("(//*[@class='dx-select-checkbox dx-datagrid-checkbox-size dx-show-invalid-badge dx-checkbox dx-widget'])[8]/div")).click();
			//Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@class='dx-item-content dx-toolbar-item-content'])[8]/div/div")).click();
		

	}

	public static String getCellValueSString(int fila, int Columna, String pagina) throws IOException {
		File file = new File("C:\\Users\\luisame\\eclipse-workspace\\KlinicTestingFramework\\Datos Entrada.xlsm");
		FileInputStream InputStream;
		try {
			InputStream = new FileInputStream(file);
			XSSFWorkbook newWorkBook = new XSSFWorkbook(InputStream);
			XSSFSheet newSheet = newWorkBook.getSheet(pagina);
			XSSFRow row = newSheet.getRow(fila);
			XSSFCell cell = row.getCell(Columna);
			return cell.getStringCellValue();
		} catch (FileNotFoundException e) {
			return "el valos no es un String";
		}
	}

	public static int getCellValuesInt(int fila, int Columna, String pagina) throws IOException {
		File file = new File("C:\\Users\\luisame\\eclipse-workspace\\KlinicTestingFramework\\Datos Entrada.xlsm");
		FileInputStream InputStream = new FileInputStream(file);
		XSSFWorkbook newWorkBook = new XSSFWorkbook(InputStream);
		XSSFSheet newSheet = newWorkBook.getSheet(pagina);
		XSSFRow row = newSheet.getRow(fila);
		XSSFCell cell = row.getCell(Columna);
		return (int) cell.getNumericCellValue();
	}
}
