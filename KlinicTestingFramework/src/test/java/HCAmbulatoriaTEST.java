//User:felipej date:06-07-2022 - 6:24pm
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import java.text.DecimalFormat;

@SuppressWarnings("unused")
public class HCAmbulatoriaTEST {
	int i = 0;
	int z=2;
	WebDriver driver;
	WebDriverWait TiempoNormaL;
	WebDriverWait TiempoMaximo;
	String Especialidad = "";
	//PLATFORM ACCES DATA
	By UsernameLocator = By.xpath("(//input[@class='dx-texteditor-input'])[1]");
	By PaswordLocator = By.xpath("(//input[@class='dx-texteditor-input'])[2]");
	By Login = By.xpath("//div[@class='dx-button dx-button-default dx-button-mode-contained dx-widget dx-button-has-text']");
	By Validacion = By.xpath("//div[@class='oph-toast-right-text']/p");
	By TarjetaFichaClinica = By.xpath("(//div[@class='cardContent-container'])[1]");
	//PATIENT FIND DATA
	By ButtonActualizar = By.xpath("((//*[@class='home-tab-background-overlay'])/..//i[@class='fas fa-sync-alt tab-icon'])");
	By OpAmbulatoria = By.xpath("//div[@id='Ambulatorio']");
	By OpcTipoDocumento = By.xpath("((//*[@class='container-forms'])/..//div[@class='dx-button-content'])[1]");
	By TipoDocumento = By.xpath("((//*[@class='container-forms'])/..//input[@class='dx-texteditor-input'])[1]");
	By TextoNumDocumento = By.xpath("((//*[@class='container-forms'])/..//input[@class='dx-texteditor-input'])[2]");
	By OpcionEstado = By.xpath("((//*[@class='container-forms'])/..//div[@class='dx-button-content'])[2]");
	By TextoEstado = By.xpath("((//*[@class='container-forms'])/..//input[@class='dx-texteditor-input'])[4]");
	By TextoFechaInicial = By.xpath("((//*[@class='container-forms'])/..//input[@class='dx-texteditor-input'])[5]");
	By TextoFechaFinal = By.xpath("((//*[@class='container-forms'])/..//input[@class='dx-texteditor-input'])[6]");
	By ButtonBuscar = By.xpath("((//*[@class='container-forms'])/..//div[@class='dx-button-content'])[5]");
	By ButtonAcceder = By.xpath("((//*[@class='container-forms'])/..//div[@class='dx-button-content'])[10]");
	By EspecialidadLocator=By.xpath("((//*[@class='container-forms'])/..//td)[19]");
	By IframeHCM = By.xpath("((//*[@class='dx-scrollview-content'])/..//iframe)[2]");
	By ButtonEspecialidad = By.xpath("((//*[@class='container-basic-data-profesional'])/..//div[@class='dx-button-content'])");//Este Xpaht se utiliza cuando el Médico tiene más de dos especialidades.
	//By ButtonEspecialidad = By.xpath("//div[@class='container-basic-data-profesional']/..//span[contains(text(),'MEDICINA DE URGENCIAS Y DOMICILIARIA')] ");
	// VARAIBLES PARA MOTIVOS DE CONSULTA	
	By HistoClinPrimVez = By.xpath("((//*[@class='dx-accordion-wrapper'])[2]/..//div[@class='dx-switch-off'])");
	By FinalidadConsulta = By.xpath("((//*[@class='dx-accordion-wrapper'])[2]/..//input)[3]");
	By FinalidadConsultaOpcion = By.xpath("(//div[@class='dx-scrollview-content']//div[@class='dx-item-content dx-list-item-content'])[last( )]");
	By MotivoConsulta = By.xpath("((//*[@class='dx-accordion-wrapper'])[2]/..//textarea)[1]");
	By EnfermedadActual = By.xpath("((//*[@class='dx-accordion-wrapper'])[2]/..//textarea)[2]");
	// VARIABLES PARA OPCIÓN SINTOMAS GENERALES	
	By OpcionSintomas = By.xpath("//a[contains(text(),'Síntomas generales por sistemas')]");
	By OpcionSintomasGenerales = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[1]");
	By OpcionOjos = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[2]");
	By OpcionBoca = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[3]");
	By OpcionOido = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[4]");
	By OpcionSistRespiratorio = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[5]");
	By OpcionSistCardiovascular = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[6]");
	By OpcionSistGastrointestinal = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[7]");
	By OpcionSistGenitourinario = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[8]");
	By OpcionSistEndocrino = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[9]");
	By OpcionSistNeurologico = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[10]");
	By OpcionSistOsteoMuscular = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[11]");
	By OpcionPielFaneras = By.xpath("((//*[@class='buttons-content'])[1]/..//li)[12]");
	By RefiereHipoactividad = By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[1]");
	By NoRefiereHipoactividad = By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//div[@class='dx-radiobutton-icon'])[2]");
	By NoEvaluadoHipoactividad = By.xpath("((//*[@class='dx-scrollable-wrapper'])/..//div[@class='dx-radiobutton-icon dx-radiobutton-icon-checked'])[1]");
	//VARIABLES PARA OPCIÓN ANTECEDENTES FAMILIARES
	
	
	
	
	
	By OpcionAntecedentesMor = By.xpath("//a[contains(text(),'Antecedentes Mórbidos')]");
	By OpcionAntecedentesFami = By.xpath("//a[contains(text(),'Antecedentes Familiares')]");
	By OpcPatologicosQui = By.xpath("//a[contains(text(),'Quirúrgicos')]");
	By OpcTraumaticos = By.xpath("//a[contains(text(),'Traumáticos')]");
	By OpcAlergicos = By.xpath("//a[contains(text(),'Alérgicos')]");
	By OpcFarma = By.xpath("//a[contains(text(),'Farmacológicos')]");
	By OpcInmunizaciones = By.xpath("//a[contains(text(),'Inmunizaciones')]");
	By OpcHabitos = By.xpath("//a[contains(text(),'Hábitos y Necesidades')]");
	By OpcPerinatales=By.xpath("//a[contains(text(),'Perinatales')]");
	By OpcPsicomotor=By.xpath("//a[contains(text(),'Psicomotor')]");
	By OpcAlimentacion=By.xpath("//a[contains(text(),'Alimentación')]");
	By OpcEpidemiologicos=By.xpath("//a[contains(text(),'Epidemiologicos')]");
	//VARIABLES AXAMEN FISICO
	By OpcionExamenFisico = By.xpath("//a[contains(text(),'Exámen Físico')]");
	By OpcionInspeccionGeneral=By.xpath("//a[contains(text(),'Inspección General')]");
	By OpcionCabeza=By.xpath("//a[contains(text(),'Cabeza')]");
	By OpcionOjo=By.xpath("//a[contains(text(),'Ojos')]");
	By OpcionNariz=By.xpath("//a[contains(text(),'Nariz')]");
	By OpcionOidos=By.xpath("//a[contains(text(),'O�dos')]");
	By OpcionBocaEF=By.xpath("//a[contains(text(),'Boca')]");
	By OpcionCuello=By.xpath("//a[contains(text(),'Cuello')]");
	By OpcionTorax=By.xpath("//a[contains(text(),'T�rax')]");
	By OpcionAbdomen=By.xpath("//a[contains(text(),'Abdomen')]");
	By SexoPaciente=By.xpath("((//*[@class='global-container'])/..//label)[5]");
	By OpcionGenitalesF=By.xpath("//a[contains(text(),'Genitales Femeninos')]");
	By OpcionGenitalesM=By.xpath("//a[contains(text(),'Genitales Masculinos')]");
	By OpcionExtremidades=By.xpath("//a[contains(text(),'Extremidades')]");
	By OpcionPiel=By.xpath("//a[contains(text(),'Piel')]");
	By OpcionNeurologico=By.xpath("//a[contains(text(),'Neurológico')]");
	By OpcionEP=By.xpath("//a[contains(text(),'Exémen psiquiátrico')]");
	// VARIABLES SIGNOS VITALES 
	By OpcionSignosVitales = By.xpath("//a[contains(text(),'Signos Vitales')]");
	By DatoEdad = By.xpath("((//*[@class='global-container ng-star-inserted'])/..//label)[3]");
	By OpcTemp = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[25]/..//div[@class='dx-button-content'])[1]");
	By TextoViaTemp = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[25]/..//input[@class='dx-texteditor-input'])[1]");
	By Temperatura = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[25]/..//input[@class='dx-texteditor-input'])[2]");
	By FrecuenciaC = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[25]/..//input[@class='dx-texteditor-input'])[3]");
	By FrecuenciaR = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[25]/..//input[@class='dx-texteditor-input'])[4]");
	By SaturacionOxigeno = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[25]/..//input[@class='dx-texteditor-input'])[5]");
	By OpcViaAdmi = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[25]/..//div[@class='dx-button-content'])[2]");
	By FraccionOxIm = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[25]/..//input[@class='dx-texteditor-input'])[7]");
	By TAASLocator = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[27]/..//input[@class='dx-texteditor-input'])[1]");
	By TAADLocator = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[27]/..//input[@class='dx-texteditor-input'])[2]");
	By TAAMLocator = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[27]/..//input[@class='dx-texteditor-input'])[3]"); //Es un campo cálcula
	By pesoLocator = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[28]/..//input[@class='dx-texteditor-input'])[1]");
	By TallaLocator = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[28]/..//input[@class='dx-texteditor-input'])[2]");
	By PerimetroAbdominalLocator = By.xpath("((//*[@class='dx-layout-manager dx-widget'])[28]/..//input[@class='dx-texteditor-input'])[3]");
	By ButtonActualizarFichaC=By.xpath("((//*[@class='dx-card responsive-paddings notBorderRadius'])/..//ul/li[3]/a/i[2])");
	//ANTECEDENTES GINECOBSTETRICOS
	By SelectFormularioAntecedGineco= By.xpath("//a[contains(text(),'Antecedentes Ginecobst�tricos')]");
	By OpcionAntecedentesGinecob = By.xpath("//a[contains(text(),'Antecedentes Ginecobstétricos')]");
	By SelectBtnMenarquia = By.xpath("(//div[@class='dx-form-group dx-group-colcount-3']/..//div[@class='dx-switch-off'])[1]");
	By SelectBtnEdadMenarquia = By.xpath("(//input[@class='dx-texteditor-input' and @inputmode='decimal'])[1]");
	By SelectBoxFechaFUR = By.xpath("//input[@name='FechaFurDTO' ]/..//input[@class='dx-texteditor-input']");
	By SelectBtnAnticoncepcion = By.xpath("(//div[@class='dx-first-col dx-last-col dx-field-item dx-col-0 dx-field-item-optional']/..//div[@class='dx-switch-off'])[1]");
	By SelectBoxMetodoAnticonceptivo = By.xpath("//input[@name='MetodoAntiConcepcionDTO' ]/..//input[@class='dx-texteditor-input']");
	By SelectListMetodoAnticonceptivo = By.xpath("(//*[@data-bind='dxControlsDescendantBindings: true']/..//*[@class='dx-scrollview-content']/..//div[@class='dx-item-content dx-list-item-content'])[1]");
	By SelectBoxFechaIniTrataAnticon = By.xpath("//input[@name='FechaInicioMetodoDto' ]/..//input[@class='dx-texteditor-input']");
	By SelectBoxFechaFinTrataAnticon = By.xpath("//input[@name='FechaFinMetodoDto' ]/..//input[@class='dx-texteditor-input']");
	By SelectBtnCitologia = By.xpath("(//div[@class='dx-widget dx-collection dx-responsivebox-screen-lg dx-responsivebox']/..//div[@class='dx-switch-off'])[4]");
	By SelectBoxFechaCitologia = By.xpath("//input[@name='FechaUltimaCitologiaDTO' ]/..//input[@class='dx-texteditor-input']");
	//CRECIMIENTO Y DESARROLLO 
	By OpcionCrecimientoDesarrollo= By.xpath("//a[contains(text(),'Crecimiento y desarrollo')]");
	By PesoLocator=By.xpath("((//dxi-item[@class='dx-template-wrapper dx-item-content dx-accordion-item-body'])[10]/..//div[@class='dx-texteditor-input-container'])[1]/input");
	By TallaLocatorcm=By.xpath("((//dxi-item[@class='dx-template-wrapper dx-item-content dx-accordion-item-body'])[10]/..//div[@class='dx-texteditor-input-container'])[2]/input");
	By CinturaLocator=By.xpath("((//dxi-item[@class='dx-template-wrapper dx-item-content dx-accordion-item-body'])[10]/..//div[@class='dx-texteditor-input-container'])[3]/input");
	By CraneanaLocator=By.xpath("((//dxi-item[@class='dx-template-wrapper dx-item-content dx-accordion-item-body'])[10]/..//div[@class='dx-texteditor-input-container'])[4]/input");
	By Valoracion1Locator=By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[400]");
	By Valoracion2Locator=By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[401]");
	By Valoracion3Locator=By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[402]");
	By Valoracion4Locator=By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[403]");
	By Valoracion5Locator=By.xpath("((//div[@class='dx-accordion-wrapper'])/..//textarea[@class='dx-texteditor-input'])[125]");	
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://factoryaut.digitalwaresaas.com.co:8082/Agora/#/login");
	}

	// Login
	@Test(priority = 0)
	public void Login() throws InterruptedException, IOException {
		String Usuario = getCellValueSString(18, 1, "Credenciales","Datos Entrada");
		String Contraseña = getCellValueSString(19, 1, "Credenciales","Datos Entrada");
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
				System.out.println("Usuario y/o   inv�lido");
			} else {

				System.out.println("Credenciales correctas");
			}
		}
	}

	// INGRESO MODULO FICHA CLINICA // OPCION AMBULATORIA
	@Test(priority = 1)
	public void ModuloFichaClinica() throws InterruptedException, IOException {
		TiempoNormaL = new WebDriverWait(driver, 10);
		TiempoMaximo = new WebDriverWait(driver, 80);
		Thread.sleep(8000);
		TiempoNormaL.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='cardContent-container'])[1]")));
		WebElement element = driver.findElement(TarjetaFichaClinica);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(TarjetaFichaClinica).click();
		Thread.sleep(8000);
		driver.switchTo().defaultContent();
		new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/oph-root/oph-side-nav-outer-toolbar/dx-drawer/div/div[2]/div[2]/div[1]/ng-component/div/div/ngb-tabset/div/div[2]/dx-scroll-view/div[1]/div/div[1]/div[2]/oph-app-viewer/div/div/iframe")));
		TiempoMaximo.until(ExpectedConditions.elementToBeClickable(OpAmbulatoria));
		Thread.sleep(800);
		driver.findElement(OpAmbulatoria).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(ButtonActualizar).click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/oph-root/oph-side-nav-outer-toolbar/dx-drawer/div/div[2]/div[2]/div[1]/ng-component/div/div/ngb-tabset/div/div[2]/dx-scroll-view/div[1]/div/div[1]/div[2]/oph-app-viewer/div/div/iframe")));
		Thread.sleep(1500);
		driver.findElement(OpAmbulatoria).click();
		Thread.sleep(4000);
	}
	
    // DILIGENCIAMIENTO DE INFORMACION A BUSCAR
	@Test(priority = 2)
	public void DiligenciamientoInformacion() throws InterruptedException, IOException {
		if(z==1) {
			i=6;
		}else if(z==2) {
			i=7;
		}else if(z==3) {
			i=8;
		}
		String Tipo_Documento = getCellValueSString(i, 1, "HC_Ambulatoria","Datos Entrada");
		String NumeroDocumento = "" + getCellValuesInt(i, 2, "HC_Ambulatoria","Datos Entrada");
		String Estado = getCellValueSString(i, 4, "HC_Ambulatoria","Datos Entrada");
		String FechaCita = getCellValueSString(i, 3, "HC_Ambulatoria","Datos Entrada");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		//new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@class='item-d']/iframe")));
		driver.switchTo().frame(0);
		DatosCriteriosBusqueda(driver, Tipo_Documento, NumeroDocumento, Estado, FechaCita);	
		Thread.sleep(1000);		 
	}
	//DILIGENCIAMIENTO DE LA HC
	@Test(priority = 3)
	public void DiligenciamientoHCAmbulatoria() throws InterruptedException, IOException {
		String MotivoConsulta=getCellValueSString(i, 5, "HC_Ambulatoria","Datos Entrada");
		String SintomasGenera=getCellValueSString(i, 6, "HC_Ambulatoria","Datos Entrada");
		String AntecedentesMorb = getCellValueSString(i, 7, "HC_Ambulatoria","Datos Entrada");
		String AntecedentesFam = getCellValueSString(i, 8, "HC_Ambulatoria","Datos Entrada");
		String AntecedentesGinecob = getCellValueSString(i, 9, "HC_Ambulatoria","Datos Entrada");
		String SignosVitales = getCellValueSString(i, 10, "HC_Ambulatoria","Datos Entrada");
		String ExamenFisico=getCellValueSString(i, 11, "HC_Ambulatoria","Datos Entrada");
		String Crecimiento=getCellValueSString(i, 12, "HC_Ambulatoria","Datos Entrada");
		
		int a=0; int b=0; int c=0;int d=0;int e=0;int f=0; int g=0; int h=0; int i=0;  int j=0; int k=0; int l=0;
		
		if(z==1) {
			a=8;b=27;c=46;d=64;e=82;f=101;g=121;h=140;i=159; j=178; k=197; l=216;
		}else if(z==2) {
			a=9;b=28;c=47;d=65;e=83;f=102;g=122;h=141;i=160; j=179; k=198; l=217;
		}else if(z==3) {
			a=10;b=29;c=48;d=66;e=84;f=103;g=123;h=142;i=161; j=180; k=199; l=218;
		}
		TiempoNormaL = new WebDriverWait(driver, 10);
		TiempoMaximo = new WebDriverWait(driver, 80);	
		Thread.sleep(1000);
		driver.switchTo().defaultContent();		
		driver.findElement(ButtonActualizarFichaC).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IframeHCM));
		TiempoMaximo.until(ExpectedConditions.elementToBeClickable(ButtonEspecialidad));
		Thread.sleep(500);
		driver.findElement(ButtonEspecialidad).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//*[@class='dx-scrollable-wrapper'])/..//div[contains(text(),'" + Especialidad + "')]")).click();
		Thread.sleep(500);
		if (Especialidad.equals("MEDICINA DE URGENCIAS Y DOMICILIARIA")) {			
			if (MotivoConsulta.equals("SI")) {
				 MotivoConsulta(a, "Historia Clinica Medicina de Urgencia");
			}
			if (SintomasGenera.equals("SI")) {
				 RevisionPorSistemas(a, b, c, d, e, f, g, h, i, j, k, l, "Historia Clinica Medicina de Urgencia");
			}
			if (AntecedentesMorb.equals("SI")) {
				 AntecedentesMorbidosMUD(driver, a, b, c, d, e, f, g, h);
			}
			if (AntecedentesFam.equals("SI")) {
				 AntecedentesFamiliaresMUD(driver, a);
			}
			if (AntecedentesGinecob.equals("SI")) {
				// AntecedentesGinecoObstetricos(driver, a);
			}
			if (SignosVitales.equals("SI")) {
				 SignosVitalesMUD(driver, a,"Historia Clinica Medicina de Urgencia");
			}
			if (ExamenFisico.equals("SI")) {
				ExamenFisicoMUD(driver, a, b, c, d, e, f, g, h);
			}			
		} else if (Especialidad.equals("PEDIATRIA")) {
			
			if (MotivoConsulta.equals("SI")) {
				 MotivoConsulta(a, "Historia Clinica Pediatria");
			}
			if (SintomasGenera.equals("SI")) {
				 RevisionPorSistemas(a, b, c, d, e, f, g, h, i, j, k, l, "Historia Clinica Pediatria");
			}
			if (AntecedentesMorb.equals("SI")) {
				AntecedentesMorbidosPediatria(driver, a, b, c, d, e, f, g, h, i, j, k, l);
			}
			if (AntecedentesFam.equals("SI")) {
				 AntecedentesFamiliaresPediatria(driver, a);
			}
			if (SignosVitales.equals("SI")) {
				 SignosVitalesPediatria(driver, a,"Historia Clinica Pediatria");
			}
			if (ExamenFisico.equals("SI")) {
				ExamenFisicoPediatria(driver, a, b, c, d, e, f, g, h);
			}
			if (Crecimiento.equals("SI")) {
				CrecimientoDesarrolloPediatria(driver,a,b,c);
			}
		}else if (Especialidad.equals("MEDICINA FISICA Y REHABILITACION")) {
			
			if (MotivoConsulta.equals("SI")) {
				 MotivoConsulta(a, "Historia Clinica Medicina Fisica");
			}
			if (SintomasGenera.equals("SI")) {
				 RevisionPorSistemas(a, b, c, d, e, f, g, h, i, j, k, l, "Historia Clinica Medicina Fisica");
			}	
			if (AntecedentesMorb.equals("SI")) {
				AntecedentesMorbidosMFisica(driver, a, b, c, d, e, f, g, h, i, j, k, l);
			}
			if (AntecedentesFam.equals("SI")) {
				AntecedentesFamiliaresMFisica(driver, a);
			}
			if (SignosVitales.equals("SI")) {
				 SignosVitalesMFisica(driver, a,"Historia Clinica Medicina Fisica");
			}
			if (ExamenFisico.equals("SI")) {
				ExamenFisicoMFisica(driver, a, b, c, d, e, f, g, h);
			}
		}
	}

	@AfterClass
	public void afterClass() {
	}

	public void DatosCriteriosBusqueda(WebDriver driver, String Tipo_Documento, String NumeroDocumento, String Estado,
			String FechaCita) throws InterruptedException {
		TiempoNormaL.until(ExpectedConditions.elementToBeClickable(OpcTipoDocumento));
		if (!Tipo_Documento.equals("")) {
			driver.findElement(OpcTipoDocumento).click();
			Thread.sleep(500);
			driver.findElement(TipoDocumento).click();
			driver.findElement(TipoDocumento).clear();
			driver.findElement(TipoDocumento).sendKeys(Tipo_Documento);
			Thread.sleep(500);
			driver.findElement(By.xpath("(//*[@class='dx-scrollable-wrapper'])/..//div[contains(text(),'" + Tipo_Documento + "')]")).click();
		} else {
		}
		if (!NumeroDocumento.equals("") || !NumeroDocumento.equals("0")) {
		} else {
			Thread.sleep(500);
			driver.findElement(TextoNumDocumento).click();
			driver.findElement(TextoNumDocumento).clear();
			driver.findElement(TextoNumDocumento).sendKeys(NumeroDocumento);
		}
		if (NumeroDocumento.equals("") || NumeroDocumento.equals("0")) {
		} else {
			Thread.sleep(1000);
			driver.findElement(TextoNumDocumento).click();
			driver.findElement(TextoNumDocumento).clear();
			driver.findElement(TextoNumDocumento).sendKeys(NumeroDocumento);
		}
		if (Estado.equals("")) {
		} else {
			driver.findElement(OpcionEstado).click();
			Thread.sleep(1000);
			driver.findElement(TextoEstado).click();
			driver.findElement(TextoEstado).clear();
			driver.findElement(TextoEstado).sendKeys(Estado);
			Thread.sleep(500);
			driver.findElement(By.xpath("(//*[@class='dx-scrollable-wrapper'])/..//div[contains(text(),'" + Estado + "')]")).click();
		}
		
		if (FechaCita.indexOf("-") != -1) {
			FechaCita = FechaCita.replace("-", "/");
		}
		Thread.sleep(500);
		if (!FechaCita.equals("")) {
			Thread.sleep(500);
			driver.findElement(TextoFechaInicial).click();
			driver.findElement(TextoFechaInicial).clear();
			driver.findElement(TextoFechaInicial).sendKeys(FechaCita);
			Thread.sleep(500);
			driver.findElement(TextoFechaFinal).click();
			driver.findElement(TextoFechaFinal).clear();
			driver.findElement(TextoFechaFinal).sendKeys(FechaCita);
		}
		Thread.sleep(500);
		driver.findElement(ButtonBuscar).click();
		Thread.sleep(3000);
		Especialidad=driver.findElement(EspecialidadLocator).getText().strip();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);		
		try {
			WebElement element1 = driver.findElement(ButtonAcceder);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(1000);
			driver.findElement(ButtonAcceder).click();
			Thread.sleep(15000);
		} catch (Exception e1) {
			System.out.println("No se encontro Historia clinica con los parametros ingresados");			
		}		
		
	}

	public void MotivoConsulta(int a,String Libro) throws IOException, InterruptedException  {
		
			String HistoClinPrimVezParametro = getCellValueSString(a,1,"MotivoConsulta",Libro);
			String FinalidadConsultaParametro = getCellValueSString(a,2,"MotivoConsulta",Libro);
			String MotivoConsultaParametro = getCellValueSString(a,3,"MotivoConsulta",Libro);
			String EnfermedadActualParametro = getCellValueSString(a,4,"MotivoConsulta",Libro);

		// Segundo Panel despues de refrescar //
		driver.switchTo().defaultContent();
		new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("((//*[@class='dx-scrollview-content'])/..//iframe)[2]")));		
		Thread.sleep(500);			
		if(HistoClinPrimVezParametro.equals("SI")) {
			driver.findElement(HistoClinPrimVez).click(); 	
		}
		System.out.println("la finalidad de la consulta es: "+FinalidadConsultaParametro);
		driver.findElement(FinalidadConsulta).sendKeys(FinalidadConsultaParametro);
		Thread.sleep(500);	
		driver.findElement(FinalidadConsultaOpcion).click();
		driver.findElement(MotivoConsulta).sendKeys(MotivoConsultaParametro);
		driver.findElement(EnfermedadActual).sendKeys(EnfermedadActualParametro); 
		
	}
	
	public void RevisionPorSistemas(int a, int b, int c, int d, int e, int f,int g,int h, int i, int j, int k,int l, String Libro) throws InterruptedException, IOException {
		Thread.sleep(500);
		driver.findElement(OpcionSintomas).click();
		Thread.sleep(500);
		String HipoactividadParametro = getCellValueSString(a,1,"SintomasGenerales",Libro); 
		String SintomasAsociadosParametro = getCellValueSString(a,3,"SintomasGenerales",Libro); 
		String AnsiedadParametro = getCellValueSString(a,5,"SintomasGenerales",Libro); 
		String DebilidadParametro = getCellValueSString(a,7,"SintomasGenerales",Libro); 
		String InsomnioParametro = getCellValueSString(a,9,"SintomasGenerales",Libro); 
		String PerdidaApetitoParametro = getCellValueSString(a,11,"SintomasGenerales",Libro); 
		String SudoracionParametro = getCellValueSString(a,13,"SintomasGenerales",Libro); 
		String PerdidaPesoParametro = getCellValueSString(a,15,"SintomasGenerales",Libro); 
		String HiperactividadParametro = getCellValueSString(a,17,"SintomasGenerales",Libro); 
		String OtrosSintomasParametro = getCellValueSString(a,19,"SintomasGenerales",Libro); 
		
		if (HipoactividadParametro.equals("") && SintomasAsociadosParametro.equals("") && AnsiedadParametro.equals("")
			&& DebilidadParametro.equals("") && InsomnioParametro.equals("") && PerdidaApetitoParametro.equals("") 
			&& SudoracionParametro.equals("") && PerdidaPesoParametro.equals("") && HiperactividadParametro.equals("")&& OtrosSintomasParametro.equals("")) {
			System.out.println("No Hay valor seleccionado en Sintomas Generales");
		} else { 	
			// CAMPOS HIPOACTIVIDAD //
			if (HipoactividadParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[1]")).click();
				String DetalleParametro = getCellValueSString(a, 2, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {					
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[1]")).sendKeys(DetalleParametro);
				}
			}
			else if (HipoactividadParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[2]")).click();
			} else if (HipoactividadParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[3]")).click();
			}			
			// CAMPOS SINTOMAS ASOCIADOS //
			if (SintomasAsociadosParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[4]")).click();
				String DetalleParametro = getCellValueSString(a, 4, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[2]")).sendKeys(DetalleParametro);
				}			
			}
			else if (SintomasAsociadosParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[5]")).click();
			} else if (SintomasAsociadosParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[6]")).click();
			}			
			// CAMPOS ANSIEDAD //
			if (AnsiedadParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[7]")).click();
				String DetalleParametro = getCellValueSString(a, 6, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[3]")).sendKeys(DetalleParametro);
				}				
			}
			else if (AnsiedadParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[8]")).click();
			} else if (AnsiedadParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[9]")).click();
			}	
			// CAMPOS DEBILIDAD //
			if (DebilidadParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[10]")).click();
				String DetalleParametro = getCellValueSString(a, 8, "SintomasGenerales",Libro);				
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[4]")).sendKeys(DetalleParametro);
				}				
			}
			else if (DebilidadParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[11]")).click();
			} else if (DebilidadParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[12]")).click();
			}			
			// CAMPOS IMSOMNIO //
			if (InsomnioParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[13]")).click();
				String DetalleParametro = getCellValueSString(a, 10, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[5]")).sendKeys(DetalleParametro);
				}				
			}
			else if (InsomnioParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[14]")).click();
			} else if (InsomnioParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[15]")).click();
			}			
			// CAMPOS P�RDIDA APETITO //
			if (PerdidaApetitoParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[16]")).click();
				String DetalleParametro = getCellValueSString(a, 12, "SintomasGenerales",Libro);			
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[6]")).sendKeys(DetalleParametro);
				}				
			}
			else if (PerdidaApetitoParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[17]")).click();
			} else if (PerdidaApetitoParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[18]")).click();
			}		
			// CAMPOS SUDORACI�N //
			if (SudoracionParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[19]")).click();
				String DetalleParametro = getCellValueSString(a, 14, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[7]")).sendKeys(DetalleParametro);
				}				
			}else if (SudoracionParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[20]")).click();
			} else if (SudoracionParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[21]")).click();
			}		
			// CAMPOS P�RDIDA DE PESO //
			if (PerdidaPesoParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[22]")).click();
				String DetalleParametro = getCellValueSString(a, 16, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[8]")).sendKeys(DetalleParametro);
				}				
			}else if (PerdidaPesoParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[23]")).click();
			} else if (PerdidaPesoParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[24]")).click();
			}			
			// CAMPOS HIPERACTIVIDAD //
			if (HiperactividadParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[25]")).click();
				String DetalleParametro = getCellValueSString(a, 18, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[9]")).sendKeys(DetalleParametro);
				}				
			}else if (HiperactividadParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[26]")).click();
			} else if (HiperactividadParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[27]")).click();
			}	
			// CAMPOS HIPERACTIVIDAD //
			if (OtrosSintomasParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[28]")).click();
				String DetalleParametro = getCellValueSString(a, 20, "SintomasGenerales", Libro);
				if (!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[10]")).sendKeys(DetalleParametro);
				}
			} else if (HiperactividadParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[29]")).click();
			} else if (HiperactividadParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[30]")).click();
			}
			WebElement element = driver.findElement(EnfermedadActual);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			 driver.findElement(OpcionSintomasGenerales).click(); 	
		} 						
		// ** VARIABLES PARAMETRIZADAS CON ARCHIVO DE EXCEL PARA OJOS ** //		
			String DipopliaParametro = getCellValueSString(b,1,"SintomasGenerales",Libro); 
			String EstrabismoParametro = getCellValueSString(b,3,"SintomasGenerales",Libro); 
			String EpiforaParametro = getCellValueSString(b,5,"SintomasGenerales",Libro); 
			String FotofobiaParametro = getCellValueSString(b,7,"SintomasGenerales",Libro); 
			String UsoAnteojosParametro = getCellValueSString(b,9,"SintomasGenerales",Libro); 
			String VisionBorrosaParametro = getCellValueSString(b,11,"SintomasGenerales",Libro); 
			String OjosOtrosParametro = getCellValueSString(b,13,"SintomasGenerales",Libro); 
		
		if (DipopliaParametro.equals("") && EstrabismoParametro.equals("") && EpiforaParametro.equals("")
				&& FotofobiaParametro.equals("") && UsoAnteojosParametro.equals("") && VisionBorrosaParametro.equals("") 
				&& OjosOtrosParametro.equals("")) {
				System.out.println("No Hay valor seleccionado en OJOS");
			} else { //-->INICIO-->//				
				driver.findElement(OpcionOjos).click();							
				// CAMPOS DIPOPL�A //
				if (DipopliaParametro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[31]")).click();
					String DetalleParametro = getCellValueSString(b, 2, "SintomasGenerales",Libro);
					if(!DetalleParametro.equals("")) {
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[11]")).sendKeys(DetalleParametro);
					}
				}else if (DipopliaParametro.equals("No Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[32]")).click();
				} else if (DipopliaParametro.equals("No Evaluado")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[33]")).click();
				}					
				// CAMPOS ESTRABISMO //
				if (EstrabismoParametro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[34]")).click();
					String DetalleParametro = getCellValueSString(b, 4, "SintomasGenerales",Libro);
					if(!DetalleParametro.equals("")) {
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[12]")).sendKeys(DetalleParametro);
					}					
				}else if (EstrabismoParametro.equals("No Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[35]")).click();
				} else if (EstrabismoParametro.equals("No Evaluado")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[36]")).click();
				}					
				// CAMPOS EP�FORA //
				if (EpiforaParametro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[37]")).click();
					String DetalleParametro = getCellValueSString(b, 6, "SintomasGenerales",Libro);
					if(!DetalleParametro.equals("")) {
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[13]")).sendKeys(DetalleParametro);
					}					
				}else if (EpiforaParametro.equals("No Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[38]")).click();
				} else if (EpiforaParametro.equals("No Evaluado")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[39]")).click();
				}				
				// CAMPOS FOTOFOBIA //
				if (FotofobiaParametro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[40]")).click();
					String DetalleParametro = getCellValueSString(b, 8, "SintomasGenerales",Libro);
					if(!DetalleParametro.equals("")) {
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[14]")).sendKeys(DetalleParametro);
					}
				}else if (FotofobiaParametro.equals("No Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[41]")).click();
				} else if (FotofobiaParametro.equals("No Evaluado")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[42]")).click();
				}				
				// CAMPOS USO DE ANTEOJOS //
				if (UsoAnteojosParametro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[43]")).click();
					String DetalleParametro = getCellValueSString(b, 10, "SintomasGenerales",Libro);
					if(!DetalleParametro.equals("")) {
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[15]")).sendKeys(DetalleParametro);
					}
				}else if (UsoAnteojosParametro.equals("No Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[44]")).click();
				} else if (UsoAnteojosParametro.equals("No Evaluado")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[45]")).click();
				}				
				// CAMPOS VISI�N BORROSA //
				if (VisionBorrosaParametro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[46]")).click();
					String DetalleParametro = getCellValueSString(b, 12, "SintomasGenerales",Libro);
					if(!DetalleParametro.equals("")) {
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[16]")).sendKeys(DetalleParametro);
					}
				}else if (VisionBorrosaParametro.equals("No Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[47]")).click();
				} else if (VisionBorrosaParametro.equals("No Evaluado")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[48]")).click();
				}				
				// CAMPOS OTROS VISION //
				if (OjosOtrosParametro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[49]")).click();
					String DetalleParametro = getCellValueSString(b, 14, "SintomasGenerales",Libro);
					if(!DetalleParametro.equals("")) {
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[17]")).sendKeys(DetalleParametro);
					}
				}else if (OjosOtrosParametro.equals("No Refiere")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[50]")).click();
				} else if (OjosOtrosParametro.equals("No Evaluado")) {
					driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[51]")).click();
				}
				WebElement element = driver.findElement(EnfermedadActual);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(500);
				driver.findElement(OpcionOjos).click();
			}			
		// ** VARIABLES PARAMETRIZADAS CON ARCHIVO DE EXCEL PARA BOCA ** //		
		String AftasParametro = getCellValueSString(c,1,"SintomasGenerales",Libro); 
		String DisfagiaParametro = getCellValueSString(c,3,"SintomasGenerales",Libro); 
		String GingivorragiaParametro = getCellValueSString(c,5,"SintomasGenerales",Libro); 
		String HalitosisParametro = getCellValueSString(c,7,"SintomasGenerales",Libro);
		String SialorreaParametro = getCellValueSString(c,9,"SintomasGenerales",Libro); 
		String BocaOtroParametro = getCellValueSString(c,11,"SintomasGenerales",Libro); 		
	
	if (AftasParametro.equals("") && DisfagiaParametro.equals("") && GingivorragiaParametro.equals("")
			&& HalitosisParametro.equals("") && SialorreaParametro.equals("") && BocaOtroParametro.equals("")) {
			System.out.println("No Hay valor seleccionado en OJOS");
		} else { 		
			driver.findElement(OpcionBoca).click();
			// CAMPOS AFTAS //
			if (AftasParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[52]")).click();
				String DetalleParametro = getCellValueSString(c, 2, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[18]")).sendKeys(DetalleParametro);
				}
			}else if (AftasParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[53]")).click();
			} else if (AftasParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[54]")).click();
			}			
			// CAMPOS DISFAGIA //
			if (DisfagiaParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[55]")).click();
				String DetalleParametro = getCellValueSString(c, 4, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[19]")).sendKeys(DetalleParametro);
				}
			}else if (DisfagiaParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[56]")).click();
			} else if (DisfagiaParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[57]")).click();
			}			
			// CAMPOS GINGIVORRAGIA //
			if (GingivorragiaParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[58]")).click();
				String DetalleParametro = getCellValueSString(c, 6, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[20]")).sendKeys(DetalleParametro);
				}
			}else if (GingivorragiaParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[59]")).click();
			} else if (GingivorragiaParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[60]")).click();
			}			
			// CAMPOS HALITOSIS //
			if (HalitosisParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[61]")).click();
				String DetalleParametro = getCellValueSString(c, 8, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[21]")).sendKeys(DetalleParametro);
				}
			}else if (HalitosisParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[62]")).click();
			} else if (HalitosisParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[63]")).click();
			}			
			// CAMPOS SIALORREA //
			if (SialorreaParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[64]")).click();
				String DetalleParametro = getCellValueSString(c, 10, "SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[22]")).sendKeys(DetalleParametro);
				}
			}else if (SialorreaParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[65]")).click();
			} else if (SialorreaParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[66]")).click();
			}			
			// CAMPOS OTRO BOCA //
			if (BocaOtroParametro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[67]")).click();
				String DetalleParametro = getCellValueSString(c, 12,"SintomasGenerales",Libro);
				if(!DetalleParametro.equals("")) {
					driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[23]")).sendKeys(DetalleParametro);
				}
			}else if (BocaOtroParametro.equals("No Refiere")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[68]")).click();
			} else if (BocaOtroParametro.equals("No Evaluado")) {
				driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[69]")).click();
			}	
			WebElement element = driver.findElement(EnfermedadActual);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			driver.findElement(OpcionBoca).click();
		} 
	// ** VARIABLES PARAMETRIZADAS CON ARCHIVO DE EXCEL PARA OIDO ** //	
				String AcufenosParametro = getCellValueSString(d,1,"SintomasGenerales",Libro); 
				String HipoAcusiaParametro = getCellValueSString(d,3,"SintomasGenerales",Libro); 
				String OtalgiaParametro = getCellValueSString(d,5,"SintomasGenerales",Libro); 
				String OtorreaParametro = getCellValueSString(d,7,"SintomasGenerales",Libro);
				String UsoAudifonosParametro = getCellValueSString(d,9,"SintomasGenerales",Libro); 
				String OtoscopiaParametro = getCellValueSString(d,11,"SintomasGenerales",Libro); 
				String OtroOidoParametro = getCellValueSString(d,11,"SintomasGenerales",Libro); 			
			
			if (AcufenosParametro.equals("") && HipoAcusiaParametro.equals("") && OtalgiaParametro.equals("")
					&& OtorreaParametro.equals("") && UsoAudifonosParametro.equals("") && OtoscopiaParametro.equals("")
					&& OtroOidoParametro.equals("")) {
					System.out.println("No Hay valor seleccionado en O�DOS");
				} else { //-->INICIO-->//
					driver.findElement(OpcionOido).click();
					// CAMPOS AC�FENOS //
					if (AcufenosParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[70]")).click();
						String DetalleParametro = getCellValueSString(d, 2, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[24]")).sendKeys(DetalleParametro);
						}
					}else if (AcufenosParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[71]")).click();
					} else if (AcufenosParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[72]")).click();
					}					
					// CAMPOS HIPOACUSIA //
					if (HipoAcusiaParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[73]")).click();
						String DetalleParametro = getCellValueSString(d, 4, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[25]")).sendKeys(DetalleParametro);
						}
					}else if (HipoAcusiaParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[74]")).click();
					} else if (HipoAcusiaParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[75]")).click();
					}				
					// CAMPOS OTALGIA //
					if (OtalgiaParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[76]")).click();
						String DetalleParametro = getCellValueSString(d, 6, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[26]")).sendKeys(DetalleParametro);
						}
					}else if (OtalgiaParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[77]")).click();
					} else if (OtalgiaParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[78]")).click();
					}					
					// CAMPOS OTORREA //
					if (OtorreaParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[79]")).click();
						String DetalleParametro = getCellValueSString(d, 8, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[27]")).sendKeys(DetalleParametro);
						}
					}else if (OtorreaParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[80]")).click();
					} else if (OtorreaParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[81]")).click();
					}					
					// CAMPOS USO DE AUD�FONOS //
					if (UsoAudifonosParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[82]")).click();
						String DetalleParametro = getCellValueSString(d, 10, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[28]")).sendKeys(DetalleParametro);
						}
					}else if (UsoAudifonosParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[83]")).click();
					} else if (UsoAudifonosParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[84]")).click();
					}					
					// CAMPOS USO DE OTOSCOP�A //
					if (OtoscopiaParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[85]")).click();
						String DetalleParametro = getCellValueSString(d, 12, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[29]")).sendKeys(DetalleParametro);
						}
					}else if (OtoscopiaParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[86]")).click();
					} else if (OtoscopiaParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[87]")).click();
					}									
					// CAMPOS OTRO O�DO //
					if (OtroOidoParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[88]")).click();
						String DetalleParametro = getCellValueSString(d, 14, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[30]")).sendKeys(DetalleParametro);
						}
					}else if (OtroOidoParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[89]")).click();
					} else if (OtroOidoParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[90]")).click();
					}
					WebElement element = driver.findElement(EnfermedadActual);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(300);
					driver.findElement(OpcionOido).click();
				}
				// ** VARIABLES PARAMETRIZADAS CON ARCHIVO DE EXCEL PARA SISTEMA RESPIRATORIO ** //	
				String RetraccionesParametro = getCellValueSString(e,1,"SintomasGenerales",Libro); 
				String AleteoNasalParametro = getCellValueSString(e,3,"SintomasGenerales",Libro); 
				String RuidosRespAnormalesParametro = getCellValueSString(e,5,"SintomasGenerales",Libro); 
				String ExpectoracionParametro = getCellValueSString(e,7,"SintomasGenerales",Libro);
				String PosicionRespirarParametro = getCellValueSString(e,9,"SintomasGenerales",Libro); 
				String TosParametro = getCellValueSString(e,11,"SintomasGenerales",Libro); 
				String RespiracionOtroParametro = getCellValueSString(e,13,"SintomasGenerales",Libro); 
							
			if (RetraccionesParametro.equals("") && AleteoNasalParametro.equals("") && RuidosRespAnormalesParametro.equals("")
					&& ExpectoracionParametro.equals("") && PosicionRespirarParametro.equals("") && TosParametro.equals("")
					&& RespiracionOtroParametro.equals("")) {
					System.out.println("No Hay valor seleccionado en SISTEMA RESPIRATORIO");
				} else { 
					driver.findElement(OpcionSistRespiratorio).click();
					// CAMPOS RETRACCIONES //
					if (RetraccionesParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[91]")).click();
						String DetalleParametro = getCellValueSString(e, 2, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[31]")).sendKeys(DetalleParametro);
						}
					}else if (RetraccionesParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[92]")).click();
					} else if (RetraccionesParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[93]")).click();
					}				
					// CAMPOS OTRO ALETEO NASAL //
					if (AleteoNasalParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[94]")).click();
						String DetalleParametro = getCellValueSString(e, 4, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[32]")).sendKeys(DetalleParametro);
						}
					}else if (AleteoNasalParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[95]")).click();
					} else if (AleteoNasalParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[96]")).click();
					}					
					// CAMPOS OTRO RUIDOS RESPIRATORIOS ANORMALES //
					if (RuidosRespAnormalesParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[97]")).click();
						String DetalleParametro = getCellValueSString(e, 6, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[33]")).sendKeys(DetalleParametro);

						}
					}else if (RuidosRespAnormalesParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[98]")).click();
					} else if (RuidosRespAnormalesParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[99]")).click();
					}					
					// CAMPOS EXPECTORACI�N //
					if (ExpectoracionParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[100]")).click();
						String DetalleParametro = getCellValueSString(e, 8, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[34]")).sendKeys(DetalleParametro);
						}
					}else if (ExpectoracionParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[101]")).click();
					} else if (ExpectoracionParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[102]")).click();
					}					
					// CAMPOS POSICI�N PARA RESPIRAR //
					if (PosicionRespirarParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[103]")).click();
						String DetalleParametro = getCellValueSString(e, 10, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[35]")).sendKeys(DetalleParametro);
						}
					}else if (PosicionRespirarParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[104]")).click();
					} else if (PosicionRespirarParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[105]")).click();
					}				
					// CAMPOS TOS //
					if (TosParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[106]")).click();
						String DetalleParametro = getCellValueSString(e, 12,"SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[36]")).sendKeys(DetalleParametro);
						}
					}else if (TosParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[107]")).click();
					} else if (TosParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[108]")).click();
					}					
					// CAMPOS SISTEMA RESPIRATRIO OTRO //
					if (RespiracionOtroParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[109]")).click();
						String DetalleParametro = getCellValueSString(e, 14, "SintomasGenerales",Libro);
						if(!DetalleParametro.equals("")) {
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[37]")).sendKeys(DetalleParametro);
						}
					}else if (RespiracionOtroParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[110]")).click();
					} else if (RespiracionOtroParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[111]")).click();
					}			
					WebElement element = driver.findElement(EnfermedadActual);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(300);
					driver.findElement(OpcionSistRespiratorio).click();
				}		
					// ** VARIABLES PARAMETRIZADAS CON ARCHIVO DE EXCEL PARA SISTEMA CARDIOVASCULAR ** //
					
					String DisneaEsfuerzoParametro = getCellValueSString(f,1,"SintomasGenerales",Libro); 
					String DisneaParaxisticaParametro = getCellValueSString(f,3,"SintomasGenerales",Libro); 
					String DolorPrecordialParametro = getCellValueSString(f,5,"SintomasGenerales",Libro); 
					String EdemaMiembrosParametro = getCellValueSString(f,7,"SintomasGenerales",Libro);
					String TaquicardiaParametro = getCellValueSString(f,9,"SintomasGenerales",Libro); 
					String OrtopneaParametro = getCellValueSString(f,11,"SintomasGenerales",Libro); 
					String SistVascularOtroParametro = getCellValueSString(f,13,"SintomasGenerales",Libro); 				
				
				if (DisneaEsfuerzoParametro.equals("") && DisneaParaxisticaParametro.equals("") && DolorPrecordialParametro.equals("")
						&& EdemaMiembrosParametro.equals("") && TaquicardiaParametro.equals("") && OrtopneaParametro.equals("")
						&& SistVascularOtroParametro.equals("")) {
						System.out.println("No Hay valor seleccionado en SISTEMA CARDIOVASCULAR");
					} else { 
						driver.findElement(OpcionSistCardiovascular).click();
						// CAMPOS DISNEA DE ESFUERZO //
						if (DisneaEsfuerzoParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[112]")).click();
							String DetalleParametro = getCellValueSString(f, 2, "SintomasGenerales",Libro);
							if(!DetalleParametro.equals("")) {
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[38]")).sendKeys(DetalleParametro);
							}
						}else if (DisneaEsfuerzoParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[113]")).click();
						} else if (DisneaEsfuerzoParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[114]")).click();
						}						
						// CAMPOS DISNEA PARAXISTICA NOSCTURNA //
						if (DisneaParaxisticaParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[115]")).click();
							String DetalleParametro = getCellValueSString(f, 4, "SintomasGenerales",Libro);
							if(!DetalleParametro.equals("")) {
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[39]")).sendKeys(DetalleParametro);
							}
						}else if (DisneaParaxisticaParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[116]")).click();
						} else if (DisneaParaxisticaParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[117]")).click();
						}						
						// CAMPOS DOLOR PRECORDIAL //
						if (DolorPrecordialParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[118]")).click();
							String DetalleParametro = getCellValueSString(f, 6, "SintomasGenerales",Libro);
							if(!DetalleParametro.equals("")) {
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[40]")).sendKeys(DetalleParametro);
							}
						}else if (DolorPrecordialParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[119]")).click();
						} else if (DolorPrecordialParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[120]")).click();
						}
												
						if (EdemaMiembrosParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[121]")).click();
							String DetalleParametro = getCellValueSString(f, 8, "SintomasGenerales",Libro);
							if(!DetalleParametro.equals("")) {
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[41]")).sendKeys(DetalleParametro);
							}
						}else if (EdemaMiembrosParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[122]")).click();
						} else if (EdemaMiembrosParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[123]")).click();
						}	
						// CAMPOS TAQUICARDIA //
						if (TaquicardiaParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[124]")).click();
							String DetalleParametro = getCellValueSString(f, 10, "SintomasGenerales",Libro);
							if(!DetalleParametro.equals("")) {
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[42]")).sendKeys(DetalleParametro);
							}
						}else if (TaquicardiaParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[125]")).click();
						} else if (TaquicardiaParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[126]")).click();
						}					
						// CAMPOS ORTOPNEA //
						if (OrtopneaParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[127]")).click();
							String DetalleParametro = getCellValueSString(f, 12, "SintomasGenerales",Libro);
							if(!DetalleParametro.equals("")) {
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[43]")).sendKeys(DetalleParametro);
							}
						}else if (OrtopneaParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[128]")).click();
						} else if (OrtopneaParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[129]")).click();
						}						
						// CAMPOS SIST CARDIO VASCULAR OTRO //
						if (SistVascularOtroParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[130]")).click();
							String DetalleParametro = getCellValueSString(f, 14, "SintomasGenerales",Libro);
							if(!DetalleParametro.equals("")) {
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[44]")).sendKeys(DetalleParametro);
							}
						}else if (SistVascularOtroParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[131]")).click();
						} else if (SistVascularOtroParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[132]")).click();
						}
						WebElement element = driver.findElement(EnfermedadActual);
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
						Thread.sleep(300);
						driver.findElement(OpcionSistCardiovascular).click();
					}								
					// ** VARIABLES PARAMETRIZADAS CON ARCHIVO DE EXCEL PARA SISTEMA GASTRO INTESTINAL ** //					
					String EstrenimientoParametro = getCellValueSString(g,1,"SintomasGenerales",Libro); 
					String FlatulenciaParametro = getCellValueSString(g,3,"SintomasGenerales",Libro); 
					String MelenasParametro = getCellValueSString(g,5,"SintomasGenerales",Libro); 
					String RectorragiaParametro = getCellValueSString(g,7,"SintomasGenerales",Libro);
					String NauseasVomitoParametro = getCellValueSString(g,9,"SintomasGenerales",Libro); 
					String DiarreaParametro = getCellValueSString(g,11,"SintomasGenerales",Libro); 
					String SistGastroOtroParametro = getCellValueSString(g,13,"SintomasGenerales",Libro); 					
				
				if (EstrenimientoParametro.equals("") && FlatulenciaParametro.equals("") && MelenasParametro.equals("")
						&& RectorragiaParametro.equals("") && NauseasVomitoParametro.equals("") && DiarreaParametro.equals("")
						&& SistGastroOtroParametro.equals("")) {
						System.out.println("No Hay valor seleccionado en SISTEMA GASTRO INTESTINAL");
					} else { 
						driver.findElement(OpcionSistGastrointestinal).click();
						// CAMPOS ESTRE�IMIENTO //
						if (EstrenimientoParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[133]")).click();
							String DetalleParametro = getCellValueSString(g, 2, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[45]")).sendKeys(DetalleParametro);
						}else if (EstrenimientoParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[134]")).click();
						} else if (EstrenimientoParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[135]")).click();
						}						
						// CAMPOS FLATULENCIA //
						if (FlatulenciaParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[136]")).click();
							String DetalleParametro = getCellValueSString(g, 4, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[46]")).sendKeys(DetalleParametro);
						}else if (FlatulenciaParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[137]")).click();
						} else if (FlatulenciaParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[138]")).click();
						}						
						// CAMPOS MELENAS //
						if (MelenasParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[139]")).click();
							String DetalleParametro = getCellValueSString(g, 6,"SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[47]")).sendKeys(DetalleParametro);
						}else if (MelenasParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[140]")).click();
						} else if (MelenasParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[141]")).click();
						}						
						// CAMPOS RECTORRAGIA //
						if (RectorragiaParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[142]")).click();
							String DetalleParametro = getCellValueSString(g, 8, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[48]")).sendKeys(DetalleParametro);
						}else if (RectorragiaParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[143]")).click();
						} else if (RectorragiaParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[144]")).click();
						}						
						// CAMPOS N�USEAS Y V�MITO //
						if (NauseasVomitoParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[145]")).click();
							String DetalleParametro = getCellValueSString(g, 10, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[49]")).sendKeys(DetalleParametro);
						}else if (NauseasVomitoParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[146]")).click();
						} else if (NauseasVomitoParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[147]")).click();
						}						
						// CAMPOS DIARR�A //
						if (DiarreaParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[148]")).click();
							String DetalleParametro = getCellValueSString(g, 12, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[50]")).sendKeys(DetalleParametro);
						}else if (DiarreaParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[149]")).click();
						} else if (DiarreaParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[150]")).click();
						}			
						// CAMPOS GASTRO INTESTINAL OTRO //
						if (SistGastroOtroParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[151]")).click();
							String DetalleParametro = getCellValueSString(g, 14, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[51]")).sendKeys(DetalleParametro);
						}else if (SistGastroOtroParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[152]")).click();
						} else if (SistGastroOtroParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[153]")).click();
						}
						WebElement element = driver.findElement(EnfermedadActual);
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
						Thread.sleep(300);
						driver.findElement(OpcionSistGastrointestinal).click();										
					}	
				// ** VARIABLES PARAMETRIZADAS CON ARCHIVO DE EXCEL PARA SISTEMA GENITOURINARIO ** //				
				String DisuriaParametro = getCellValueSString(h,1,"SintomasGenerales",Libro); 
				String NicturiaParametro = getCellValueSString(h,3,"SintomasGenerales",Libro); 
				String PoliuriaParametro = getCellValueSString(h,5,"SintomasGenerales",Libro); 
				String DolorLumbarParametro = getCellValueSString(h,7,"SintomasGenerales",Libro);
				String PolaquiuriaParametro = getCellValueSString(h,9,"SintomasGenerales",Libro); 
				String SistUrinarioOtroParametro = getCellValueSString(h,11,"SintomasGenerales",Libro); 
				
				
			if (DisuriaParametro.equals("") && NicturiaParametro.equals("") && PoliuriaParametro.equals("")
					&& DolorLumbarParametro.equals("") && PolaquiuriaParametro.equals("") && SistUrinarioOtroParametro.equals("")) {
					System.out.println("No Hay valor seleccionado en SISTEMA GENITOURINARIO");
				} else {
					driver.findElement(OpcionSistGenitourinario).click();
					// CAMPOS DISURIA //
					if (DisuriaParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[154]")).click();
						String DetalleParametro = getCellValueSString(h, 2, "SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[52]")).sendKeys(DetalleParametro);
					}else if (DisuriaParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[155]")).click();
					} else if (DisuriaParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[156]")).click();
					}					
					// CAMPOS NICTURIA //
					if (NicturiaParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[157]")).click();
						String DetalleParametro = getCellValueSString(h, 4, "SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[53]")).sendKeys(DetalleParametro);
					}else if (NicturiaParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[158]")).click();
					} else if (NicturiaParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[159]")).click();
					}
					// CAMPOS POLIURIA //
					if (PoliuriaParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[160]")).click();
						String DetalleParametro = getCellValueSString(h, 6, "SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[54]")).sendKeys(DetalleParametro);
					}else if (PoliuriaParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[161]")).click();
					} else if (PoliuriaParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[162]")).click();
					}
					// CAMPOS DOLOR LUMBAR //
					if (DolorLumbarParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[163]")).click();
						String DetalleParametro = getCellValueSString(h, 8, "SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[55]")).sendKeys(DetalleParametro);
					}else if (DolorLumbarParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[164]")).click();
					} else if (DolorLumbarParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[165]")).click();
					}					
					// CAMPOS POLAQUIURIA //
					if (PolaquiuriaParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[166]")).click();
						String DetalleParametro = getCellValueSString(h, 10, "SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[56]")).sendKeys(DetalleParametro);
					}else if (PolaquiuriaParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[167]")).click();
					} else if (PolaquiuriaParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[168]")).click();
					}					
					// CAMPOS SIST URINARIO OTRO //
					if (SistUrinarioOtroParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[169]")).click();
						String DetalleParametro = getCellValueSString(h, 12, "SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[57]")).sendKeys(DetalleParametro);
					}else if (SistUrinarioOtroParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[170]")).click();
					} else if (SistUrinarioOtroParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[171]")).click();
					}
					WebElement element = driver.findElement(EnfermedadActual);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(300);
					driver.findElement(OpcionSistGenitourinario).click();									
				}
				// ** VARIABLES PARAMETRIZADAS CON ARCHIVO DE EXCEL PARA SISTEMA ENDOCRINO ** //				
				String BajaPesoParametro = getCellValueSString(i,1,"SintomasGenerales",Libro); 
				String SomnolenciaParametro = getCellValueSString(i,3,"SintomasGenerales",Libro); 
				String ResequedadPielParametro = getCellValueSString(i,5,"SintomasGenerales",Libro); 
				String IntoleraFrioCalorParametro = getCellValueSString(i,7,"SintomasGenerales",Libro); 
				String TemblorFinoParametro = getCellValueSString(i,9,"SintomasGenerales",Libro);
				String SistEndocrinoOtroParametro = getCellValueSString(i,11,"SintomasGenerales",Libro); 						
				
			if (BajaPesoParametro.equals("") && SomnolenciaParametro.equals("") && ResequedadPielParametro.equals("")
					&& IntoleraFrioCalorParametro.equals("") && TemblorFinoParametro.equals("") && SistEndocrinoOtroParametro.equals("")) {
					System.out.println("No Hay valor seleccionado en SISTEMA ENDOCRINO");
				} else { 
					driver.findElement(OpcionSistEndocrino).click();
					// CAMPOS BAJA DE PESO //
					if (BajaPesoParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[172]")).click();
						String DetalleParametro = getCellValueSString(i, 2, "SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[58]")).sendKeys(DetalleParametro);
					}else if (BajaPesoParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[173]")).click();
					} else if (BajaPesoParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[174]")).click();
					}					
					// CAMPOS SOMNOLENCIA //
					if (SomnolenciaParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[175]")).click();
						String DetalleParametro = getCellValueSString(i, 4, "SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[59]")).sendKeys(DetalleParametro);
					}else if (SomnolenciaParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[176]")).click();
					} else if (SomnolenciaParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[177]")).click();
					}					
					// CAMPOS RESEQUEDAD DE LA PIEL //
					if (ResequedadPielParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[178]")).click();
						String DetalleParametro = getCellValueSString(i, 6, "SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[60]")).sendKeys(DetalleParametro);
					}else if (ResequedadPielParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[179]")).click();
					} else if (ResequedadPielParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[180]")).click();
					}					
					// CAMPOS INTOLERANCIA A FR�O O CALOR //
					if (IntoleraFrioCalorParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[181]")).click();
						String DetalleParametro = getCellValueSString(i, 8,"SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[61]")).sendKeys(DetalleParametro);
					}else if (IntoleraFrioCalorParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[182]")).click();
					} else if (IntoleraFrioCalorParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[183]")).click();
					}					
					// CAMPOS TEMBLOR FINO //
					if (TemblorFinoParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[184]")).click();
						String DetalleParametro = getCellValueSString(i, 10, "SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[62]")).sendKeys(DetalleParametro);
					}else if (TemblorFinoParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[185]")).click();
					} else if (TemblorFinoParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[186]")).click();
					}					
					// CAMPOS SISTEMA ENDOCRINO OTRO //
					if (SistEndocrinoOtroParametro.equals("Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[187]")).click();
						String DetalleParametro = getCellValueSString(i, 12, "SintomasGenerales",Libro);
						driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[63]")).sendKeys(DetalleParametro);
					}else if (SistEndocrinoOtroParametro.equals("No Refiere")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[188]")).click();
					} else if (SistEndocrinoOtroParametro.equals("No Evaluado")) {
						driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[189]")).click();
					}
					WebElement element = driver.findElement(EnfermedadActual);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(300);
					driver.findElement(OpcionSistEndocrino).click();
				} 		
					// ** VARIABLES PARAMETRIZADAS CON ARCHIVO DE EXCEL PARA SISTEMA NEUROL�GICO ** //				
					String CefaleaParametro = getCellValueSString(j,1,"SintomasGenerales",Libro); 
					String PareciasParametro = getCellValueSString(j,3,"SintomasGenerales",Libro); 
					String MareosParametro = getCellValueSString(j,5,"SintomasGenerales",Libro); 
					String ParestesiasParametro = getCellValueSString(j,7,"SintomasGenerales",Libro); 
					String ProblemasCoordinacionParametro = getCellValueSString(j,9,"SintomasGenerales",Libro);
					String SistNeuroOtroParametro = getCellValueSString(j,11,"SintomasGenerales",Libro); 
											
				if (CefaleaParametro.equals("") && PareciasParametro.equals("") && MareosParametro.equals("")
						&& ParestesiasParametro.equals("") && ProblemasCoordinacionParametro.equals("") && SistNeuroOtroParametro.equals("")){
						System.out.println("No Hay valor seleccionado en SISTEMA NEUROL�GICO");
					} else {
						driver.findElement(OpcionSistNeurologico).click();
						// CAMPOS CEFALEA //
						if (CefaleaParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[190]")).click();
							String DetalleParametro = getCellValueSString(j, 2, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[64]")).sendKeys(DetalleParametro);
						}else if (CefaleaParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[191]")).click();
						} else if (CefaleaParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[192]")).click();
						}						
						// CAMPOS PARECIAS //
						if (PareciasParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[193]")).click();
							String DetalleParametro = getCellValueSString(j, 4, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[65]")).sendKeys(DetalleParametro);
						}else if (PareciasParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[194]")).click();
						} else if (PareciasParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[195]")).click();
						}						
						// CAMPOS MAREOS //
						if (MareosParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[196]")).click();
							String DetalleParametro = getCellValueSString(j, 6, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[66]")).sendKeys(DetalleParametro);
						}else if (MareosParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[197]")).click();
						} else if (MareosParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[198]")).click();
						}											
						// CAMPOS PARESTESIAS -->>>>>>>>> //
						if (ParestesiasParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[199]")).click();
							String DetalleParametro = getCellValueSString(j, 8, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[67]")).sendKeys(DetalleParametro);
						}else if (ParestesiasParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[200]")).click();
						} else if (ParestesiasParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[201]")).click();
						}						
						// CAMPOS PROBLEMAS COORDINACI�N //
						if (ProblemasCoordinacionParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[202]")).click();
							String DetalleParametro = getCellValueSString(j, 10, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[68]")).sendKeys(DetalleParametro);
						}else if (ProblemasCoordinacionParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[203]")).click();
						} else if (ProblemasCoordinacionParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[204]")).click();
						}						
						// CAMPOS SISTEMA NEUROL�GICO OTROS  //
						if (SistNeuroOtroParametro.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[205]")).click();
							String DetalleParametro = getCellValueSString(j, 12, "SintomasGenerales",Libro);
							driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[69]")).sendKeys(DetalleParametro);
						}else if (SistNeuroOtroParametro.equals("No Refiere")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[206]")).click();
						} else if (SistNeuroOtroParametro.equals("No Evaluado")) {
							driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[207]")).click();
						}	
						WebElement element = driver.findElement(EnfermedadActual);
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
						Thread.sleep(300);
						driver.findElement(OpcionSistNeurologico).click();
					} 			
							// ** VARIABLES PARAMETRIZADAS CON ARCHIVO DE EXCEL PARA SISTEMA OSTEO MUSCULAR ** //							
							String AnquilosisParametro = getCellValueSString(k,1,"SintomasGenerales",Libro); 
							String ArtralgiasParametro = getCellValueSString(k,3,"SintomasGenerales",Libro); 
							String ClaudicacionParametro = getCellValueSString(k,5,"SintomasGenerales",Libro); 
							String MialgiasParametro = getCellValueSString(k,7,"SintomasGenerales",Libro); 
							String OligoartalgiasParametro = getCellValueSString(k,9,"SintomasGenerales",Libro);
							String SistOsteoMusOtroParametro = getCellValueSString(k,11,"SintomasGenerales",Libro); 
															
						if (AnquilosisParametro.equals("") && ArtralgiasParametro.equals("") && ClaudicacionParametro.equals("")
								&& MialgiasParametro.equals("") && OligoartalgiasParametro.equals("") && SistOsteoMusOtroParametro.equals("")) {
								System.out.println("No Hay valor seleccionado en SISTEMA OSTEO MUSCULAR");
							} else { //-->INICIO-->//
								driver.findElement(OpcionSistOsteoMuscular).click();
							// CAMPOS ANQUILOSIS  //
							if (AnquilosisParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[208]")).click();
								String DetalleParametro = getCellValueSString(k, 2,"SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[70]")).sendKeys(DetalleParametro);
							}else if (AnquilosisParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[209]")).click();
							} else if (AnquilosisParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[210]")).click();
							}								
							// CAMPOS ARTRALGIAS  //
							if (ArtralgiasParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[211]")).click();
								String DetalleParametro = getCellValueSString(k, 4, "SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[71]")).sendKeys(DetalleParametro);
							}else if (ArtralgiasParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[212]")).click();
							} else if (ArtralgiasParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[213]")).click();
							}							
							// CAMPOS CLAUDICACI�N  //
							if (ClaudicacionParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[214]")).click();
								String DetalleParametro = getCellValueSString(k, 6, "SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[72]")).sendKeys(DetalleParametro);
							}else if (ClaudicacionParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[215]")).click();
							} else if (ClaudicacionParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[216]")).click();
							}								
							// CAMPOS MIALGIAS  //
							if (MialgiasParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[217]")).click();
								String DetalleParametro = getCellValueSString(k, 8, "SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[73]")).sendKeys(DetalleParametro);
							}else if (MialgiasParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[218]")).click();
							} else if (MialgiasParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[219]")).click();
							}								
							// CAMPOS OLIGOARTALGIAS  //
							if (OligoartalgiasParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[220]")).click();
								String DetalleParametro = getCellValueSString(k, 10, "SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[74]")).sendKeys(DetalleParametro);
							}else if (OligoartalgiasParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[221]")).click();
							} else if (OligoartalgiasParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[222]")).click();
							}							
							// CAMPOS SIST OSTEO MUSCULAR OTRO  //
							if (SistOsteoMusOtroParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[223]")).click();
								String DetalleParametro = getCellValueSString(k, 12, "SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[75]")).sendKeys(DetalleParametro);
							}else if (SistOsteoMusOtroParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[224]")).click();
							} else if (SistOsteoMusOtroParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[225]")).click();
							}
							WebElement element = driver.findElement(EnfermedadActual);
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							Thread.sleep(500);
							driver.findElement(OpcionSistOsteoMuscular).click();
					} 						
						// ** VARIABLES PARAMETRIZADAS CON ARCHIVO DE EXCEL PARA PIEL Y FANERAS ** //						
						String AparicionTumoresParametro = getCellValueSString(l,1,"SintomasGenerales",Libro); 
						String CaidaCabelloParametro = getCellValueSString(l,3,"SintomasGenerales",Libro); 
						String ErupcionCutaneaParametro = getCellValueSString(l,5,"SintomasGenerales",Libro); 
						String PigmentacionParametro = getCellValueSString(l,7,"SintomasGenerales",Libro); 
						String UrticariaParametro = getCellValueSString(l,9,"SintomasGenerales",Libro);
						String PielFanerasOtroParametro = getCellValueSString(l,11,"SintomasGenerales",Libro); 
								
						
					if (AparicionTumoresParametro.equals("") && CaidaCabelloParametro.equals("") && ErupcionCutaneaParametro.equals("")
							&& PigmentacionParametro.equals("") && UrticariaParametro.equals("") && PielFanerasOtroParametro.equals("")) {
							System.out.println("No Hay valor seleccionado en SISTEMA PIEL Y FANERAS");
						} else { //-->INICIO-->//
							driver.findElement(OpcionPielFaneras).click();
							// CAMPOS APARICI�N TUMORES  //
							if (AparicionTumoresParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[226]")).click();
								String DetalleParametro = getCellValueSString(l, 2, "SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[76]")).sendKeys(DetalleParametro);
							}else if (AparicionTumoresParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[227]")).click();
							} else if (AparicionTumoresParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[228]")).click();
							}						
							// CAMPOS CA�DA DE CABELLO  //
							if (CaidaCabelloParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[229]")).click();
								String DetalleParametro = getCellValueSString(l, 4, "SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[77]")).sendKeys(DetalleParametro);
							}else if (CaidaCabelloParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[230]")).click();
							} else if (CaidaCabelloParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[231]")).click();
							}						
							// CAMPOS ERUPCI�N CUT�NEA  //
							if (ErupcionCutaneaParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[232]")).click();
								String DetalleParametro = getCellValueSString(l, 6, "SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[78]")).sendKeys(DetalleParametro);
							}else if (ErupcionCutaneaParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[233]")).click();
							} else if (ErupcionCutaneaParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[234]")).click();
							}							
							// CAMPOS PIGMENTACI�N  //
							if (PigmentacionParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[235]")).click();
								String DetalleParametro = getCellValueSString(l, 8, "SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[79]")).sendKeys(DetalleParametro);
							}else if (PigmentacionParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[236]")).click();
							} else if (PigmentacionParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[237]")).click();
							}							
							// CAMPOS URTIC�RIA  //
							if (UrticariaParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[238]")).click();
								String DetalleParametro = getCellValueSString(l, 10, "SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[80]")).sendKeys(DetalleParametro);
							}else if (UrticariaParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[239]")).click();
							} else if (UrticariaParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[240]")).click();
							}							
							// CAMPOS OTROS PIEL Y FANERAS //
							if (PielFanerasOtroParametro.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[241]")).click();
								String DetalleParametro = getCellValueSString(l, 12, "SintomasGenerales",Libro);
								driver.findElement(By.xpath("((//*[@class='item ng-star-inserted'])/..//textarea)[81]")).sendKeys(DetalleParametro);
							}else if (PielFanerasOtroParametro.equals("No Refiere")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[242]")).click();
							} else if (PielFanerasOtroParametro.equals("No Evaluado")) {
								driver.findElement(By.xpath("((//*[@class='item-content'])/..//div[@class='dx-radio-value-container'])[243]")).click();
							}	
							WebElement element = driver.findElement(EnfermedadActual);
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							Thread.sleep(300);
							driver.findElement(OpcionPielFaneras).click();							
						} // --> FIN --> //
			}
	
	public void AntecedentesMorbidosMUD(WebDriver driver, int a, int b, int c, int d, int e, int f,int g,int h) throws InterruptedException, IOException {
		Thread.sleep(500);
		driver.findElement(OpcionAntecedentesMor).click();
		Thread.sleep(1000);
			// Antesedente M�dicos
			String EstadoHipertension = getCellValueSString(a, 1, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoCancer = getCellValueSString(a, 5, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoITU = getCellValueSString(a, 9, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoSindrome = getCellValueSString(a, 13, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoLeusemia = getCellValueSString(a, 17, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoDiabetes = getCellValueSString(a, 21, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoIRA = getCellValueSString(a, 25, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoAsma = getCellValueSString(a, 29, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoOtros = getCellValueSString(a, 33, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			if (EstadoHipertension.equals("") && EstadoCancer.equals("") && EstadoITU.equals("")
					&& EstadoSindrome.equals("") && EstadoLeusemia.equals("") && EstadoDiabetes.equals("")
					&& EstadoIRA.equals("") && EstadoAsma.equals("") && EstadoOtros.equals("")) {
				System.out.println("No se selecciono ningun Antesedente de M�dicos");
			} else {
				// DATOS HIPERTENSION ARTERIAL
				if (EstadoHipertension.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[1]")).click();
					String Condicion = getCellValueSString(a, 2, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[4]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[5]")).click();
					}
					String Texto1 = getCellValueSString(a, 3, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(a, 4, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						Thread.sleep(500);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[1]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[2]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[2]")).sendKeys(Texto2);
					}					
				} else if (EstadoHipertension.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[2]")).click();
				} else if (EstadoHipertension.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[3]")).click();
				}
				// DATOS CANCER
				if (EstadoCancer.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[6]")).click();
					String Condicion = getCellValueSString(a, 6, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[9]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[10]")).click();
					}
					String Texto1 = getCellValueSString(a, 7, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(a, 8, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");					
					if(!Texto1.equals("")) {
						Thread.sleep(500);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[3]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[4]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[4]")).sendKeys(Texto2);
					}					
				} else if (EstadoCancer.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[7]")).click();
				} else if (EstadoCancer.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[8]")).click();
				}
				// DATOS ITU
				if (EstadoITU.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[11]")).click();
					String Condicion = getCellValueSString(a, 10, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[14]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[15]")).click();
					}
					String Texto1 = getCellValueSString(a, 11, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(a, 12, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");					
					if(!Texto1.equals("")) {
						Thread.sleep(500);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[5]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[6]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[6]")).sendKeys(Texto2);
					}					
				} else if (EstadoITU.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[12]")).click();
				} else if (EstadoITU.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[13]")).click();
				}
				// DATOS S�ndrome Diarreico
				if (EstadoSindrome.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[16]")).click();
					String Condicion = getCellValueSString(a, 14, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[19]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[20]")).click();
					}
					String Texto1 = getCellValueSString(a, 15, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(a, 16, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						Thread.sleep(500);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[7]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[8]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[8]")).sendKeys(Texto2);
					}					
				} else if (EstadoSindrome.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[17]")).click();
				} else if (EstadoSindrome.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[18]")).click();
				}
				// DATOS Leucemia
				if (EstadoLeusemia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[21]")).click();
					String Condicion = getCellValueSString(a, 18, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[24]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[25]")).click();
					}
					String Texto1 = getCellValueSString(a, 19, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(a, 20, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						Thread.sleep(500);					
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[9]")).sendKeys(Texto1);						
					}
					if(!Texto2.equals("")) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[10]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[10]")).sendKeys(Texto2);
					}					
				} else if (EstadoLeusemia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[22]")).click();
				} else if (EstadoLeusemia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[23]")).click();
				}
				// DATOS DIABETES
				if (EstadoDiabetes.equals("Refiere")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]")).click();
					String Condicion = getCellValueSString(a, 22, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[29]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[30]")).click();
					}
					String Texto1 = getCellValueSString(a, 23, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(a, 24, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						Thread.sleep(500);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[11]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[12]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[12]")).sendKeys(Texto2);
					}					
				} else if (EstadoDiabetes.equals("Niega")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[27]")).click();
				} else if (EstadoDiabetes.equals("No evaluado")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[28]")).click();
				}
				// DATOS IRA
				if (EstadoIRA.equals("Refiere")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[31]")).click();
					String Condicion = getCellValueSString(a, 26, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[34]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[35]")).click();
					}
					String Texto1 = getCellValueSString(a, 27, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(a, 28, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[13]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[14]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[14]")).sendKeys(Texto2);
					}
				} else if (EstadoIRA.equals("Niega")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[32]")).click();
				} else if (EstadoIRA.equals("No evaluado")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[33]")).click();
				}
				// DATOS ASMA
				if (EstadoAsma.equals("Refiere")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[36]")).click();
					String Condicion = getCellValueSString(a, 30, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[39]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[40]")).click();
					}
					String Texto1 = getCellValueSString(a, 31, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(a, 32, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[15]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[16]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[16]")).sendKeys(Texto2);
					}
				} else if (EstadoAsma.equals("Niega")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[37]")).click();
				} else if (EstadoAsma.equals("No evaluado")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[38]")).click();
				}
				// DATOS OTROS
				if (EstadoOtros.equals("Refiere")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[41]")).click();
					String Condicion = getCellValueSString(a, 34, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[44]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[45]")).click();
					}
					String Texto1 = getCellValueSString(a, 35, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(a, 36, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[17]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[18]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[18]")).sendKeys(Texto2);
					}
				} else if (EstadoOtros.equals("Niega")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[42]")).click();
				} else if (EstadoOtros.equals("No evaluado")) {
					WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[43]")).click();
				}
				Thread.sleep(500);
				WebElement element = driver.findElement(By.xpath("(//*[@class='dx-item-content dx-accordion-item-title'])[4]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			}
			// Patol�gicos Quir�rgicos
			String Estadovesico = getCellValueSString(b, 1, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoHerniorrafia = getCellValueSString(b, 5, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoApendicectomia = getCellValueSString(b, 9, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoGastro = getCellValueSString(b, 13, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoOtro = getCellValueSString(b, 17, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			if (Estadovesico.equals("") && EstadoHerniorrafia.equals("") && EstadoApendicectomia.equals("")
					&& EstadoGastro.equals("") && EstadoOtro.equals("")) {
				System.out.println("No se selecciono ningun Antesedente  Quir�rgicos");
			} else {
				WebElement element = driver.findElement(OpcionPielFaneras);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(500);
				driver.findElement(OpcPatologicosQui).click();
				Thread.sleep(500);

				// Datos Anti reflujo vesicoureteral
				if (Estadovesico.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[46]")).click();
					String Condicion = getCellValueSString(b, 2, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[2]")).click();
					}
					String Texto1 = getCellValueSString(b, 3, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(b, 4, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[19]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[1]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[1]")).sendKeys(Texto2);
					}
				} else if (Estadovesico.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[47]")).click();
				} else if (Estadovesico.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[48]")).click();
				}
				// DATOS Herniorrafia
				if (EstadoHerniorrafia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[49]")).click();
					String Condicion = getCellValueSString(b, 6, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[3]")).click();
					}
					String Texto1 = getCellValueSString(b, 7, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(b, 8, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[20]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[2]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[2]")).sendKeys(Texto2);
					}
				} else if (EstadoHerniorrafia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[50]")).click();
				} else if (EstadoHerniorrafia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[51]")).click();
				}
				// DATOS Apendicectomía
				if (EstadoApendicectomia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[52]")).click();
					String Condicion = getCellValueSString(b, 10, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[4]")).click();
					}
					String Texto1 = getCellValueSString(b, 11, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(b, 12, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[21]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[3]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[3]")).sendKeys(Texto2);
					}
				} else if (EstadoApendicectomia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[53]")).click();
				} else if (EstadoApendicectomia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[54]")).click();
				}
				// DATOS Anti Reflujo gastroesof�gico
				if (EstadoGastro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[55]")).click();
					String Condicion = getCellValueSString(b, 14, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[5]")).click();
					}
					String Texto1 = getCellValueSString(b, 15, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(b, 16, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[22]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[4]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[4]")).sendKeys(Texto2);
					}
				} else if (EstadoGastro.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[56]")).click();
				} else if (EstadoGastro.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[57]")).click();
				}
				// DATOS Otros
				if (EstadoOtro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[58]")).click();
					String Condicion = getCellValueSString(b, 18, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[6]")).click();
					}
					String Texto1 = getCellValueSString(b, 19, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(b, 20, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[23]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[5]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[5]")).sendKeys(Texto2);
					}
				} else if (EstadoOtro.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[59]")).click();
				} else if (EstadoOtro.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[60]")).click();
				}
			}
			// Traum�ticos
			String EstadoTrauma = getCellValueSString(c, 1, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoFracturas = getCellValueSString(c, 5, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoViolencia = getCellValueSString(c, 9, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoHeridas = getCellValueSString(c, 13, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoOtros1 = getCellValueSString(c, 17, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			if (EstadoTrauma.equals("") && EstadoFracturas.equals("") && EstadoViolencia.equals("")
					&& EstadoHeridas.equals("") && EstadoOtros1.equals("")) {
				System.out.println("No se selecciono ningun Antesedente  Traumaticos");
			} else {
				Thread.sleep(500);
				driver.findElement(OpcTraumaticos).click();
				Thread.sleep(500);
				// Datos Anti reflujo vesicoureteral
				if (EstadoTrauma.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[61]")).click();
					String Condicion = getCellValueSString(c, 3, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[7]")).click();
					}
					String Texto1 = getCellValueSString(c, 2, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(c, 4, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[6]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[7]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[7]")).sendKeys(Texto2);
					}
				} else if (EstadoTrauma.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[62]")).click();
				} else if (EstadoTrauma.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[63]")).click();
				}
				// DATOS Herniorrafia
				if (EstadoFracturas.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[64]")).click();
					String Condicion = getCellValueSString(c, 7, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[8]")).click();
					}
					String Texto1 = getCellValueSString(c, 6, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(c, 8, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[8]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[9]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[9]")).sendKeys(Texto2);
					}
				} else if (EstadoFracturas.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[65]")).click();
				} else if (EstadoFracturas.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[66]")).click();
				}
				// DATOS Apendicectom�a
				if (EstadoViolencia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[67]")).click();
					String Condicion = getCellValueSString(c, 11, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[9]")).click();
					}
					String Texto1 = getCellValueSString(c, 10, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(c, 12, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {					
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[10]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[11]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[11]")).sendKeys(Texto2);
					}
				} else if (EstadoViolencia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[68]")).click();
				} else if (EstadoViolencia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[69]")).click();
				}
				// DATOS Anti Reflujo gastroesof�gico
				if (EstadoHeridas.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[70]")).click();
					String Condicion = getCellValueSString(c, 15, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[10]")).click();
					}
					String Texto1 = getCellValueSString(c, 14, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(c, 16, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[12]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[13]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[13]")).sendKeys(Texto2);
					}
				} else if (EstadoHeridas.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[71]")).click();
				} else if (EstadoHeridas.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[72]")).click();
				}
				// DATOS Otros
				if (EstadoOtros1.equals("Refiere")) {
					WebElement element = driver.findElement(OpcPatologicosQui);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[73]")).click();
					String Condicion = getCellValueSString(c, 19, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[11]")).click();
					}
					String Texto1 = getCellValueSString(c, 18, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(c, 20, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[14]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[15]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[15]")).sendKeys(Texto2);
					}
				} else if (EstadoOtros1.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[74]")).click();
				} else if (EstadoOtros1.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[75]")).click();
				}
			}
			// Al�rgicos
			String EstadoMedicamento = getCellValueSString(d, 1, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoLatex = getCellValueSString(d, 6, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoAlimento = getCellValueSString(d, 11, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoYodo = getCellValueSString(d, 16, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoOtros2 = getCellValueSString(d, 21, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			if (EstadoMedicamento.equals("") && EstadoLatex.equals("") && EstadoAlimento.equals("")
					&& EstadoYodo.equals("") && EstadoOtros2.equals("")) {
				System.out.println("No se selecciono ningun Antesedente  Al�rgicos");
			} else {
				Thread.sleep(500);
				driver.findElement(OpcAlergicos).click();
				Thread.sleep(500);
				// Datos Medicamentos
				if (EstadoMedicamento.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[76]")).click();
					Thread.sleep(500);
					String Texto1 = getCellValueSString(d, 2, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(d, 3, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[16]")).sendKeys(Texto1);
						Thread.sleep(300);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[17]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[17]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 4, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");					
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[12]")).click();
					}										
					String Texto3 = getCellValueSString(d, 5, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");										
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[18]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[18]")).sendKeys(Texto3);
					}
				} else if (EstadoMedicamento.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[77]")).click();
				} else if (EstadoMedicamento.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[78]")).click();
				}
				// DATOS Latex
				if (EstadoLatex.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[79]")).click();
					String Texto1 = getCellValueSString(d, 7, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(d, 8, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[19]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[20]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[20]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 9, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[13]")).click();
					}
					Thread.sleep(500);					
					String Texto3 = getCellValueSString(d, 10, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[21]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[21]")).sendKeys(Texto3);
					}
				} else if (EstadoLatex.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[80]")).click();
				} else if (EstadoLatex.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[81]")).click();
				}
				// DATOS Alimentos
				if (EstadoAlimento.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[82]")).click();
					String Texto1 = getCellValueSString(d, 12, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(d, 13, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[22]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {					
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[23]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[23]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 14, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[14]")).click();
					}
					Thread.sleep(500);					
					String Texto3 = getCellValueSString(d, 15, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[24]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[24]")).sendKeys(Texto3);
					}
				} else if (EstadoAlimento.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[83]")).click();
				} else if (EstadoAlimento.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[84]")).click();
				}
				// DATOS Yodo
				if (EstadoYodo.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[85]")).click();
					String Texto1 = getCellValueSString(d, 17, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(d, 18, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[25]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[26]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[26]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 19, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[15]")).click();
					}					
					String Texto3 = getCellValueSString(d, 20, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[27]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[27]")).sendKeys(Texto3);
					}
				} else if (EstadoYodo.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[86]")).click();
				} else if (EstadoYodo.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[87]")).click();
				}
				// DATOS Otros
				if (EstadoOtros2.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[88]")).click();
					String Texto1 = getCellValueSString(d, 22, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(d, 23, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[28]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {					
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[29]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[29]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 24, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[16]")).click();
					}									
					String Texto3 = getCellValueSString(d, 25, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[30]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[30]")).sendKeys(Texto3);
					}
				} else if (EstadoOtros2.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[89]")).click();
				} else if (EstadoOtros2.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[90]")).click();
				}
			}
			// Farmacol�gicos
			String EstadoMedicamentoAlo = getCellValueSString(e, 1, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoOxigeno = getCellValueSString(e, 6, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoMedicamentosHome = getCellValueSString(e, 11, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoOtros3 = getCellValueSString(e, 16, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");

			if (EstadoMedicamentoAlo.equals("") && EstadoOxigeno.equals("") && EstadoMedicamentosHome.equals("")
					&& EstadoOtros3.equals("")) {
				System.out.println("No se selecciono ningun Antesedente  Farmacologicos");
			} else {
				Thread.sleep(500);
				driver.findElement(OpcFarma).click();
				Thread.sleep(500);
				// Datos Medicamentos
				if (EstadoMedicamentoAlo.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[91]")).click();
					String Texto1 = getCellValueSString(e, 2, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(e, 3, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[31]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[32]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[32]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 4, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[17]")).click();
					}					
					String Texto3 = getCellValueSString(e, 5, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					Thread.sleep(500);					
					if(!Texto2.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[33]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[33]")).sendKeys(Texto3);
					}
				} else if (EstadoMedicamentoAlo.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[92]")).click();
				} else if (EstadoMedicamentoAlo.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[93]")).click();
				}
				// DATOS Latex
				if (EstadoOxigeno.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[94]")).click();
					String Texto1 = getCellValueSString(e, 7, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(e, 8, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])34]")).sendKeys(Texto1);
					}
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[35]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[35]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 9, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[18]")).click();
					}					
					String Texto3 = getCellValueSString(e, 10, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[36]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[36]")).sendKeys(Texto3);
					}
				} else if (EstadoOxigeno.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[95]")).click();
				} else if (EstadoOxigeno.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[96]")).click();
				}
				// DATOS Alimentos
				if (EstadoMedicamentosHome.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[97]")).click();
					String Texto1 = getCellValueSString(e, 12, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(e, 13, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[37]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[38]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[38]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 14, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[19]")).click();
					}				
					String Texto3 = getCellValueSString(e, 15, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[39]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[39]")).sendKeys(Texto3);
					}
				} else if (EstadoMedicamentosHome.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[98]")).click();
				} else if (EstadoMedicamentosHome.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[99]")).click();
				}
				// DATOS Otros
				if (EstadoOtros3.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[100]")).click();
					String Texto1 = getCellValueSString(e, 17, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Texto2 = getCellValueSString(e, 18, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[40]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[41]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[41]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 19, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[20]")).click();
					}					
					String Texto3 = getCellValueSString(e, 20, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					Thread.sleep(500);	
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[42]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[42]")).sendKeys(Texto3);
					}
				} else if (EstadoOtros3.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[101]")).click();
				} else if (EstadoOtros3.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[102]")).click();
				}
			}
			// Inmunizaciones 
			String VEPNI1 = getCellValueSString(f, 1, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI2 = getCellValueSString(f, 3, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI3 = getCellValueSString(f, 5, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI4 = getCellValueSString(f, 7, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI5 = getCellValueSString(f, 9, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI6 = getCellValueSString(f, 11, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI7 = getCellValueSString(f, 13, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI8 = getCellValueSString(f, 15, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI9 = getCellValueSString(f, 17, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI10 = getCellValueSString(f, 19, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI11 = getCellValueSString(f, 21, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI12 = getCellValueSString(f, 23, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI13 = getCellValueSString(f, 25, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI14 = getCellValueSString(f, 27, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI15 = getCellValueSString(f, 29, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI16 = getCellValueSString(f, 31, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String VEPNI17 = getCellValueSString(f, 33, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			driver.findElement(OpcInmunizaciones).click();
			Thread.sleep(500);	
			if (VEPNI1.equals("") && VEPNI2.equals("") && VEPNI3.equals("") && VEPNI4.equals("") && VEPNI5.equals("")
					&& VEPNI6.equals("") && VEPNI7.equals("") && VEPNI8.equals("") && VEPNI9.equals("")
					&& VEPNI10.equals("") && VEPNI11.equals("") && VEPNI12.equals("") && VEPNI13.equals("")
					&& VEPNI14.equals("") && VEPNI15.equals("") && VEPNI16.equals("") && VEPNI17.equals("")) {				
				System.out.print("No hay datos en Vacunas Extras PNI");
				WebElement element = driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[4]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(500);	
				driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[5]")).click();
			}else {		
				if(VEPNI1.equals("SI")) {
					String Text=getCellValueSString(f, 2, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[1]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[1]")).sendKeys(Text);
				}
				if(VEPNI2.equals("SI")) {
					String Text=getCellValueSString(f, 4, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[2]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[2]")).sendKeys(Text);
				}
				if(VEPNI3.equals("SI")) {
					String Text=getCellValueSString(f, 6, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[3]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[3]")).sendKeys(Text);
				}
				if(VEPNI4.equals("SI")) {
					String Text=getCellValueSString(f, 8, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[4]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[4]")).sendKeys(Text);
				}
				if(VEPNI5.equals("SI")) {
					String Text=getCellValueSString(f, 10, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[5]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[5]")).sendKeys(Text);
				}
				if(VEPNI6.equals("SI")) {
					String Text=getCellValueSString(f, 12, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[6]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[6]")).sendKeys(Text);
				}
				if(VEPNI7.equals("SI")) {
					String Text=getCellValueSString(f, 14, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[7]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[7]")).sendKeys(Text);
				}
				if(VEPNI8.equals("SI")) {
					String Text=getCellValueSString(f, 16, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[8]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[8]")).sendKeys(Text);
				}
				if(VEPNI9.equals("SI")) {
					String Text=getCellValueSString(f, 18, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[9]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[9]")).sendKeys(Text);
				}
				if(VEPNI10.equals("SI")) {
					String Text=getCellValueSString(f, 20, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[10]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[10]")).sendKeys(Text);
				}
				if(VEPNI11.equals("SI")) {
					String Text=getCellValueSString(f, 22, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[11]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[11]")).sendKeys(Text);
				}
				if(VEPNI12.equals("SI")) {
					String Text=getCellValueSString(f, 24, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[12]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[12]")).sendKeys(Text);
				}
				if(VEPNI13.equals("SI")) {
					String Text=getCellValueSString(f, 26, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[13]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[13]")).sendKeys(Text);
				}
				if(VEPNI14.equals("SI")) {
					String Text=getCellValueSString(f, 28, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[14]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[14]")).sendKeys(Text);
				}
				if(VEPNI15.equals("SI")) {
					String Text=getCellValueSString(f, 30, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[15]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[15]")).sendKeys(Text);
				}
				if(VEPNI16.equals("SI")) {
					String Text=getCellValueSString(f, 32, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[16]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[16]")).sendKeys(Text);
				}
				if(VEPNI17.equals("SI")) {
					String Text=getCellValueSString(f, 34, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[17]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[17]")).sendKeys(Text);
				}
			}
			
			// Inmunizaciones
			String VPNI1 = getCellValueSString(g, 1, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI2 = getCellValueSString(g, 4, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI3 = getCellValueSString(g, 10, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI4 = getCellValueSString(g, 14, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI5 = getCellValueSString(g, 20, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI6 = getCellValueSString(g, 23, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI7 = getCellValueSString(g, 27, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI8 = getCellValueSString(g, 29, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI9 = getCellValueSString(g, 32, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI10 = getCellValueSString(g, 35, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI11 = getCellValueSString(g, 38, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI12 = getCellValueSString(g, 42, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			String VPNI13 = getCellValueSString(g, 45, "AntecedentesMorbidos", "Historia Clinica Medicina de Urgencia");
			driver.findElement(OpcInmunizaciones).click();
			if (VPNI1.equals("") && VPNI2.equals("") && VPNI3.equals("") && VPNI4.equals("") && VPNI5.equals("")
					&& VPNI6.equals("") && VPNI7.equals("") && VPNI8.equals("") && VPNI9.equals("")
					&& VPNI10.equals("") && VPNI11.equals("") && VPNI12.equals("") && VPNI13.equals("")) {
				System.out.print("No hay datos en Vacunas Extras PNI");
				driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[6]")).click();
			}else {				
				if(VPNI1.equals("SI")) {
					String Opc=getCellValueSString(g, 2, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(Opc.equals("X")|| Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[1]")).click();
					}
					String Text=getCellValueSString(g, 3, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[1]")).sendKeys(Text);
					}			
				}
				if(VPNI2.equals("SI")) {
					String Opc1=getCellValueSString(g, 5, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Opc2=getCellValueSString(g, 6, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Opc3=getCellValueSString(g, 7, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Opc4=getCellValueSString(g, 8, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(Opc1.equals("X")|| Opc1.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[2]")).click();
					}
					if(Opc2.equals("X")|| Opc2.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[3]")).click();
					}
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[4]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[5]")).click();
					}
					String Text=getCellValueSString(g, 9, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[2]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[2]")).sendKeys(Text);
					}			
				}
				if(VPNI3.equals("SI")) {
					String Opc3=getCellValueSString(g, 11, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Opc4=getCellValueSString(g, 12, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");				
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[6]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[7]")).click();
					}
					String Text=getCellValueSString(g, 13, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[3]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[3]")).sendKeys(Text);
					}			
				}
				if(VPNI4.equals("SI")) {
					String Opc1=getCellValueSString(g, 15, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Opc2=getCellValueSString(g, 16, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Opc3=getCellValueSString(g, 17, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Opc4=getCellValueSString(g, 18, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(Opc1.equals("X")|| Opc1.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[8]")).click();
					}
					if(Opc2.equals("X")|| Opc2.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[9]")).click();
					}
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[10]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[11]")).click();
					}
					String Text=getCellValueSString(g, 19, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[4]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[4]")).sendKeys(Text);
					}			
				}
				if (VPNI5.equals("SI")) {
					String Opc = getCellValueSString(g, 21, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[12]")).click();
					}
					String Text = getCellValueSString(g, 22, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[5]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[5]")).sendKeys(Text);
					}
				}
				if(VPNI6.equals("SI")) {
					String Opc = getCellValueSString(g, 24, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[13]")).click();
					}
					String Text = getCellValueSString(g, 25, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[6]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[6]")).sendKeys(Text);
					}
				}
				if(VPNI7.equals("SI")) {
					String Opc = getCellValueSString(g, 27, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[14]")).click();
					}
					String Text = getCellValueSString(g, 28, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[7]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[7]")).sendKeys(Text);
					}
				}
				if(VPNI8.equals("SI")) {
					String Opc = getCellValueSString(g, 30, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[15]")).click();
					}
					String Text = getCellValueSString(g, 31, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[8]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[8]")).sendKeys(Text);
					}
				}
				if(VPNI9.equals("SI")) {
					String Opc = getCellValueSString(g, 33, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[16]")).click();
					}
					String Text = getCellValueSString(g, 34, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[9]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[9]")).sendKeys(Text);
					}
				}
				if(VPNI10.equals("SI")) {
					String Opc = getCellValueSString(g, 36, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[17]")).click();
					}
					String Text = getCellValueSString(g, 37, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[10]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[10]")).sendKeys(Text);
					}
				}
				if(VPNI11.equals("SI")) {
					String Opc3=getCellValueSString(g, 39, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Opc4=getCellValueSString(g, 40, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");				
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[18]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[19]")).click();
					}
					String Text=getCellValueSString(g, 41, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[11]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[11]")).sendKeys(Text);
					}		
				}
				if(VPNI12.equals("SI")) {
					String Opc = getCellValueSString(g, 43, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[20]")).click();
					}
					String Text = getCellValueSString(g, 44, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[12]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[12]")).sendKeys(Text);
					}
				}
				if(VPNI13.equals("SI")) {
					String Opc3=getCellValueSString(g, 46, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					String Opc4=getCellValueSString(g, 47, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");				
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[21]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[22]")).click();
					}
					String Text=getCellValueSString(g, 48, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[13]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[13]")).sendKeys(Text);
					}		
				}
			}
			// H�bitos y Necesidades
			String EstadoHigiene = getCellValueSString(h, 1, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoEjercicio = getCellValueSString(h, 3, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoDependencia = getCellValueSString(h, 5, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoTabaquismo = getCellValueSString(h, 7, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoHigieneoral = getCellValueSString(h, 9, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoProblemas = getCellValueSString(h, 11, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoAusencia = getCellValueSString(h, 13, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoDificultades = getCellValueSString(h, 15, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoAlcohol = getCellValueSString(h, 17, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoDrogas = getCellValueSString(h, 19, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			String EstadoOtro4 = getCellValueSString(h, 21, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
			if (EstadoHigiene.equals("") && EstadoEjercicio.equals("") && EstadoDependencia.equals("")
					&& EstadoTabaquismo.equals("") && EstadoHigieneoral.equals("") && EstadoProblemas.equals("")
					&& EstadoAusencia.equals("") && EstadoDificultades.equals("") && EstadoAlcohol.equals("")
					&& EstadoDrogas.equals("") && EstadoOtro4.equals("")) {

			} else {
				WebElement element = driver.findElement(OpcionPielFaneras);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(500);
				driver.findElement(OpcHabitos).click();
				Thread.sleep(500);
				// DATOS Higiene personal diaria
				if (EstadoHigiene.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[103]")).click();
					String Texto1 = getCellValueSString(h, 2, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[43]")).sendKeys(Texto1);
				} else if (EstadoHigiene.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[104]")).click();
				} else if (EstadoHigiene.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[105]")).click();
				}
				// DATOS Ejercicio
				if (EstadoEjercicio.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[106]")).click();
					String Texto1 = getCellValueSString(h, 4, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[44]")).sendKeys(Texto1);
				} else if (EstadoEjercicio.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[107]")).click();
				} else if (EstadoEjercicio.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[108]")).click();
				}
				// DATOS Dependencia al cuidador primario
				if (EstadoDependencia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[109]")).click();					
					String Texto1 = getCellValueSString(h, 6, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[45]")).sendKeys(Texto1);
				} else if (EstadoDependencia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[110]")).click();
				} else if (EstadoDependencia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[111]")).click();
				}
				// DATOS Tabaquismo
				if (EstadoTabaquismo.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[112]")).click();					
					String Texto1 = getCellValueSString(h, 8, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[46]")).sendKeys(Texto1);
				} else if (EstadoTabaquismo.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[113]")).click();
				} else if (EstadoTabaquismo.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[114]")).click();
				}
				// DATOS Higiene oral > 2 veces al d�a
				if (EstadoHigieneoral.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[115]")).click();					
					String Texto1 = getCellValueSString(h, 10, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[47]")).sendKeys(Texto1);
				} else if (EstadoHigieneoral.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[116]")).click();
				} else if (EstadoHigieneoral.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[117]")).click();
				}
				// DATOS Problemas con la alimentaci�n
				if (EstadoProblemas.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[118]")).click();					
					String Texto1 = getCellValueSString(h, 12, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[48]")).sendKeys(Texto1);
				} else if (EstadoProblemas.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[119]")).click();
				} else if (EstadoProblemas.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]")).click();
				}
				// DATOS Ausencia del control de esf�nteres
				if (EstadoAusencia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[121]")).click();					
					String Texto1 = getCellValueSString(h, 14, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[49]")).sendKeys(Texto1);
				} else if (EstadoAusencia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[122]")).click();
				} else if (EstadoAusencia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[123]")).click();
				}
				// DATOS Dificultades con el sue�o
				if (EstadoDificultades.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[124]")).click();				
					String Texto1 = getCellValueSString(h, 16, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[50]")).sendKeys(Texto1);
				} else if (EstadoDificultades.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[125]")).click();
				} else if (EstadoDificultades.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[126]")).click();
				}
				// DATOS Alcohol
				if (EstadoAlcohol.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[127]")).click();					
					String Texto1 = getCellValueSString(h, 18, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[51]")).sendKeys(Texto1);
				} else if (EstadoAlcohol.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[128]")).click();
				} else if (EstadoAlcohol.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[129]")).click();
				}
				// DATOS Drogas Recreativas
				if (EstadoDrogas.equals("Refiere")) {
					WebElement element1 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[130]")).click();					
					String Texto1 = getCellValueSString(h, 20, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[52]")).sendKeys(Texto1);
				} else if (EstadoDrogas.equals("Niega")) {
					WebElement element2 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[131]")).click();
				} else if (EstadoDrogas.equals("No evaluado")) {
					WebElement element3 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[132]")).click();
				}
				// DATOS Otros
				if (EstadoOtro4.equals("Refiere")) {
					WebElement element4 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[133]")).click();				
					String Texto1 = getCellValueSString(h, 22, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[53]")).sendKeys(Texto1);
				} else if (EstadoOtro4.equals("Niega")) {
					WebElement element5 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element5);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[134]")).click();
				} else if (EstadoOtro4.equals("No evaluado")) {
					WebElement element6 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element6);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[135]")).click();
				}
				Thread.sleep(500);
				WebElement element7 = driver.findElement(By.xpath("(//*[@class='dx-item-content dx-accordion-item-title'])[3]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element7);
			}

		

	}

	public void AntecedentesMorbidosPediatria(WebDriver driver, int a, int b, int c, int d, int e, int f,int g,int h, int i, int j, int k,int l) throws InterruptedException, IOException {
		Thread.sleep(500);
		driver.findElement(OpcionAntecedentesMor).click();
		Thread.sleep(1000);
			// Antesedente M�dicos
			String EstadoITU = getCellValueSString(a, 1, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoSindrome = getCellValueSString(a, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoIRA = getCellValueSString(a, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoAsma = getCellValueSString(a, 13, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadopRUEBA1000 = getCellValueSString(a, 17, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoOtros = getCellValueSString(a, 21, "AntecedentesMorbidos","Historia Clinica Pediatria");
			System.out.println("ITU "+EstadoITU);
			System.out.println("Sindrome  "+EstadoSindrome);
			if ( EstadoITU.equals("")&& EstadoSindrome.equals("")&& EstadopRUEBA1000.equals("")
					&& EstadoIRA.equals("") && EstadoAsma.equals("") && EstadoOtros.equals("")) {
				System.out.println("No se selecciono ningun Antesedente de M�dicos");
			} else {				
				// DATOS ITU
				if (EstadoITU.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[1]")).click();
					String Condicion = getCellValueSString(a, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[4]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[5]")).click();
					}
					String Texto1 = getCellValueSString(a, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(a, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");					
					if(!Texto1.equals("")) {
						Thread.sleep(500);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[1]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[2]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[2]")).sendKeys(Texto2);
					}					
				} else if (EstadoITU.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[2]")).click();
				} else if (EstadoITU.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[3]")).click();
				}
				// DATOS S�ndrome Diarreico
				if (EstadoSindrome.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[6]")).click();
					String Condicion = getCellValueSString(a, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[9]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[10]")).click();
					}
					String Texto1 = getCellValueSString(a, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(a, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						Thread.sleep(500);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[3]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[4]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[4]")).sendKeys(Texto2);
					}					
				} else if (EstadoSindrome.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[7]")).click();
				} else if (EstadoSindrome.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[8]")).click();
				}								
				// DATOS IRA
				if (EstadoIRA.equals("Refiere")) {					
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[11]")).click();
					String Condicion = getCellValueSString(a, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[14]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[15]")).click();
					}
					String Texto1 = getCellValueSString(a, 11, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(a, 12, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[5]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[6]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[6]")).sendKeys(Texto2);
					}
				} else if (EstadoIRA.equals("Niega")) {					
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[12]")).click();
				} else if (EstadoIRA.equals("No evaluado")) {					
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[13]")).click();
				}
				// DATOS ASMA
				if (EstadoAsma.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[16]")).click();
					String Condicion = getCellValueSString(a, 14, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[19]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[20]")).click();
					}
					String Texto1 = getCellValueSString(a, 15, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(a, 16, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[7]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[8]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[8]")).sendKeys(Texto2);
					}
				} else if (EstadoAsma.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[17]")).click();
				} else if (EstadoAsma.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[18]")).click();
				}
				// DATOS PRUEBA1000
				if (EstadopRUEBA1000.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[21]")).click();
					String Condicion = getCellValueSString(a, 18, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[24]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[25]")).click();
					}
					String Texto1 = getCellValueSString(a, 19, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(a, 20, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[9]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[10]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[10]")).sendKeys(Texto2);
					}
				} else if (EstadopRUEBA1000.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[22]")).click();
				} else if (EstadopRUEBA1000.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[23]")).click();
				}
				// DATOS OTROS
				if (EstadoOtros.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]")).click();
					String Condicion = getCellValueSString(a, 22, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("Activo")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[29]")).click();
					} else {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[30]")).click();
					}
					String Texto1 = getCellValueSString(a, 23, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(a, 24, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[11]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[12]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[12]")).sendKeys(Texto2);
					}
				} else if (EstadoOtros.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[27]")).click();
				} else if (EstadoOtros.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[28]")).click();
				}
				Thread.sleep(500);
				WebElement element = driver.findElement(By.xpath("(//*[@class='dx-item-content dx-accordion-item-title'])[6]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			}
			// Patol�gicos Quir�rgicos
			String Estadovesico = getCellValueSString(b, 1, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoHerniorrafia = getCellValueSString(b, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoApendicectomia = getCellValueSString(b, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoGastro = getCellValueSString(b, 13, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoOtro = getCellValueSString(b, 17, "AntecedentesMorbidos","Historia Clinica Pediatria");
			if (Estadovesico.equals("") && EstadoHerniorrafia.equals("") && EstadoApendicectomia.equals("")
					&& EstadoGastro.equals("") && EstadoOtro.equals("")) {
				System.out.println("No se selecciono ningun Antesedente  Quir�rgicos");
			} else {
				Thread.sleep(500);
				driver.findElement(OpcPatologicosQui).click();
				Thread.sleep(500);
				// Datos Anti reflujo vesicoureteral
				if (Estadovesico.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[31]")).click();
					String Condicion = getCellValueSString(b, 2, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[2]")).click();
					}
					String Texto1 = getCellValueSString(b, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(b, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[13]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[1]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[1]")).sendKeys(Texto2);
					}
				} else if (Estadovesico.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[32]")).click();
				} else if (Estadovesico.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[33]")).click();
				}
				// DATOS Herniorrafia
				if (EstadoHerniorrafia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[34]")).click();
					String Condicion = getCellValueSString(b, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[3]")).click();
					}
					String Texto1 = getCellValueSString(b, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(b, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[14]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[2]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[2]")).sendKeys(Texto2);
					}
				} else if (EstadoHerniorrafia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[35]")).click();
				} else if (EstadoHerniorrafia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[36]")).click();
				}
				// DATOS Apendicectom�a
				if (EstadoApendicectomia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[37]")).click();
					String Condicion = getCellValueSString(b, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[4]")).click();
					}
					String Texto1 = getCellValueSString(b, 11, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(b, 12, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[15]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[3]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[3]")).sendKeys(Texto2);
					}
				} else if (EstadoApendicectomia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[38]")).click();
				} else if (EstadoApendicectomia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[39]")).click();
				}
				// DATOS Anti Reflujo gastroesof�gico
				if (EstadoGastro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[40]")).click();
					String Condicion = getCellValueSString(b, 14, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[5]")).click();
					}
					String Texto1 = getCellValueSString(b, 15, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(b, 16, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[16]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[4]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[4]")).sendKeys(Texto2);
					}
				} else if (EstadoGastro.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[41]")).click();
				} else if (EstadoGastro.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[42]")).click();
				}
				// DATOS Otros
				if (EstadoOtro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[43]")).click();
					String Condicion = getCellValueSString(b, 18, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[6]")).click();
					}
					String Texto1 = getCellValueSString(b, 19, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(b, 20, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[17]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[5]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[5]")).sendKeys(Texto2);
					}
				} else if (EstadoOtro.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[44]")).click();
				} else if (EstadoOtro.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[45]")).click();
				}
			}
			
			
			// Traum�ticos
			String EstadoTrauma = getCellValueSString(c, 1, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoFracturas = getCellValueSString(c, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoViolencia = getCellValueSString(c, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoHeridas = getCellValueSString(c, 13, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoOtros1 = getCellValueSString(c, 17, "AntecedentesMorbidos","Historia Clinica Pediatria");
			if (EstadoTrauma.equals("") && EstadoFracturas.equals("") && EstadoViolencia.equals("")
					&& EstadoHeridas.equals("") && EstadoOtros1.equals("")) {

			} else {
				Thread.sleep(500);
				driver.findElement(OpcTraumaticos).click();
				Thread.sleep(500);
				// Datos Anti reflujo vesicoureteral
				if (EstadoTrauma.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[46]")).click();
					String Condicion = getCellValueSString(c, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[7]")).click();
					}
					String Texto1 = getCellValueSString(c, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(c, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[6]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[7]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[7]")).sendKeys(Texto2);
					}
				} else if (EstadoTrauma.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[47]")).click();
				} else if (EstadoTrauma.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[48]")).click();
				}
				// DATOS Herniorrafia
				if (EstadoFracturas.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[49]")).click();
					String Condicion = getCellValueSString(c, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[8]")).click();
					}
					String Texto1 = getCellValueSString(c, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(c, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[8]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[9]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[9]")).sendKeys(Texto2);
					}
				} else if (EstadoFracturas.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[50]")).click();
				} else if (EstadoFracturas.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[51]")).click();
				}
				// DATOS Apendicectom�a
				if (EstadoViolencia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[52]")).click();
					String Condicion = getCellValueSString(c, 11, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[9]")).click();
					}
					String Texto1 = getCellValueSString(c, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(c, 12, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {					
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[10]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[11]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[11]")).sendKeys(Texto2);
					}
				} else if (EstadoViolencia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[53]")).click();
				} else if (EstadoViolencia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[54]")).click();
				}
				// DATOS Anti Reflujo gastroesof�gico
				if (EstadoHeridas.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[55]")).click();
					String Condicion = getCellValueSString(c, 15, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[10]")).click();
					}
					String Texto1 = getCellValueSString(c, 14, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(c, 16, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[12]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[13]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[13]")).sendKeys(Texto2);
					}
				} else if (EstadoHeridas.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[56]")).click();
				} else if (EstadoHeridas.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[57]")).click();
				}
				// DATOS Otros
				if (EstadoOtros1.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[58]")).click();
					String Condicion = getCellValueSString(c, 19, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[11]")).click();
					}
					String Texto1 = getCellValueSString(c, 18, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(c, 20, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[14]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[15]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[15]")).sendKeys(Texto2);
					}
				} else if (EstadoOtros1.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[59]")).click();
				} else if (EstadoOtros1.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[60]")).click();
				}
			}
			// Al�rgicos
			String EstadoMedicamento = getCellValueSString(d, 1, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoAlimento = getCellValueSString(d, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoYodo = getCellValueSString(d, 11, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoOtros2 = getCellValueSString(d, 26, "AntecedentesMorbidos","Historia Clinica Pediatria");
			if (EstadoMedicamento.equals("")  && EstadoAlimento.equals("")
					&& EstadoYodo.equals("") && EstadoOtros2.equals("")) {

			} else {
				Thread.sleep(500);
				driver.findElement(OpcAlergicos).click();
				Thread.sleep(500);
				// Datos Medicamentos
				if (EstadoMedicamento.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[61]")).click();
					Thread.sleep(500);
					String Texto1 = getCellValueSString(d, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(d, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[16]")).sendKeys(Texto1);
						Thread.sleep(300);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[17]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[17]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");					
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[7]")).click();
					}										
					String Texto3 = getCellValueSString(d, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");										
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[18]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[18]")).sendKeys(Texto3);
					}
				} else if (EstadoMedicamento.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[62]")).click();
				} else if (EstadoMedicamento.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[63]")).click();
				}			
				// DATOS Alimentos
				if (EstadoAlimento.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[64]")).click();
					String Texto1 = getCellValueSString(d, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(d, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[19]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {					
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[20]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[20]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[8]")).click();
					}
					Thread.sleep(500);					
					String Texto3 = getCellValueSString(d, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[21]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[21]")).sendKeys(Texto3);
					}
				} else if (EstadoAlimento.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[65]")).click();
				} else if (EstadoAlimento.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[66]")).click();
				}
				// DATOS Yodo
				if (EstadoYodo.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[67]")).click();
					String Texto1 = getCellValueSString(d, 17, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(d, 18, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[22]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[23]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[23]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 19, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[9]")).click();
					}					
					String Texto3 = getCellValueSString(d, 20, "AntecedentesMorbidos","Historia Clinica Pediatria");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[24]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[24]")).sendKeys(Texto3);
					}
				} else if (EstadoYodo.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[68]")).click();
				} else if (EstadoYodo.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[69]")).click();
				}
				// DATOS Otros
				if (EstadoOtros2.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[70]")).click();
					String Texto1 = getCellValueSString(d, 22, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(d, 23, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[25]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {					
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[26]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[26]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 24, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[10]")).click();
					}									
					String Texto3 = getCellValueSString(d, 25, "AntecedentesMorbidos","Historia Clinica Pediatria");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[27]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[27]")).sendKeys(Texto3);
					}
				} else if (EstadoOtros2.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[71]")).click();
				} else if (EstadoOtros2.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[72]")).click();
				}
			}
			// Farmacol�gicos
			String EstadoMedicamentoAlo = getCellValueSString(e, 1, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoOxigeno = getCellValueSString(e, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoMedicamentosHome = getCellValueSString(e, 11, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoOtros3 = getCellValueSString(e, 16, "AntecedentesMorbidos","Historia Clinica Pediatria");

			if (EstadoMedicamentoAlo.equals("") && EstadoOxigeno.equals("") && EstadoMedicamentosHome.equals("")
					&& EstadoOtros3.equals("")) {

			} else {
				Thread.sleep(500);
				driver.findElement(OpcFarma).click();
				Thread.sleep(500);
				// Datos Medicamentos
				if (EstadoMedicamentoAlo.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[73]")).click();
					String Texto1 = getCellValueSString(e, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(e, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[28]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[29]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[29]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[11]")).click();
					}					
					String Texto3 = getCellValueSString(e, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");
					Thread.sleep(500);					
					if(!Texto2.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[30]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[30]")).sendKeys(Texto3);
					}
				} else if (EstadoMedicamentoAlo.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[74]")).click();
				} else if (EstadoMedicamentoAlo.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[75]")).click();
				}
				// DATOS Latex
				if (EstadoOxigeno.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[76]")).click();
					String Texto1 = getCellValueSString(e, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(e, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])31]")).sendKeys(Texto1);
					}
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[32]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[32]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[12]")).click();
					}					
					String Texto3 = getCellValueSString(e, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[33]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[33]")).sendKeys(Texto3);
					}
				} else if (EstadoOxigeno.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[77]")).click();
				} else if (EstadoOxigeno.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[78]")).click();
				}
				// DATOS Alimentos
				if (EstadoMedicamentosHome.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[79]")).click();
					String Texto1 = getCellValueSString(e, 12, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(e, 13, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[34]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[35]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[35]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 14, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[13]")).click();
					}				
					String Texto3 = getCellValueSString(e, 15, "AntecedentesMorbidos","Historia Clinica Pediatria");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[36]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[36]")).sendKeys(Texto3);
					}
				} else if (EstadoMedicamentosHome.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[80]")).click();
				} else if (EstadoMedicamentosHome.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[81]")).click();
				}
				// DATOS Otros
				if (EstadoOtros3.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[82]")).click();
					String Texto1 = getCellValueSString(e, 17, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Texto2 = getCellValueSString(e, 18, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[37]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[38]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[38]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 19, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[14]")).click();
					}					
					String Texto3 = getCellValueSString(e, 20, "AntecedentesMorbidos","Historia Clinica Pediatria");
					Thread.sleep(500);	
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[39]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[39]")).sendKeys(Texto3);
					}
				} else if (EstadoOtros3.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[83]")).click();
				} else if (EstadoOtros3.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[84]")).click();
				}
			}
			// Inmunizaciones 
			String VEPNI1 = getCellValueSString(f, 1, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI2 = getCellValueSString(f, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI3 = getCellValueSString(f, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI4 = getCellValueSString(f, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI5 = getCellValueSString(f, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI6 = getCellValueSString(f, 11, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI7 = getCellValueSString(f, 13, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI8 = getCellValueSString(f, 15, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI9 = getCellValueSString(f, 17, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI10 = getCellValueSString(f, 19, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI11 = getCellValueSString(f, 21, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI12 = getCellValueSString(f, 23, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI13 = getCellValueSString(f, 25, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI14 = getCellValueSString(f, 27, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI15 = getCellValueSString(f, 29, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI16 = getCellValueSString(f, 31, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String VEPNI17 = getCellValueSString(f, 33, "AntecedentesMorbidos","Historia Clinica Pediatria");
			driver.findElement(OpcInmunizaciones).click();
			Thread.sleep(500);	
			if (VEPNI1.equals("") && VEPNI2.equals("") && VEPNI3.equals("") && VEPNI4.equals("") && VEPNI5.equals("")
					&& VEPNI6.equals("") && VEPNI7.equals("") && VEPNI8.equals("") && VEPNI9.equals("")
					&& VEPNI10.equals("") && VEPNI11.equals("") && VEPNI12.equals("") && VEPNI13.equals("")
					&& VEPNI14.equals("") && VEPNI15.equals("") && VEPNI16.equals("") && VEPNI17.equals("")) {				
				System.out.println("No hay datos en Vacunas Extras PNI");
				WebElement element = driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[5]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(500);	
				driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[7]")).click();
			}else {		
				if(VEPNI1.equals("SI")) {
					String Text=getCellValueSString(f, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[1]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[1]")).sendKeys(Text);
				}
				if(VEPNI2.equals("SI")) {
					String Text=getCellValueSString(f, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[2]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[2]")).sendKeys(Text);
				}
				if(VEPNI3.equals("SI")) {
					String Text=getCellValueSString(f, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[3]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[3]")).sendKeys(Text);
				}
				if(VEPNI4.equals("SI")) {
					String Text=getCellValueSString(f, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[4]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[4]")).sendKeys(Text);
				}
				if(VEPNI5.equals("SI")) {
					String Text=getCellValueSString(f, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[5]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[5]")).sendKeys(Text);
				}
				if(VEPNI6.equals("SI")) {
					String Text=getCellValueSString(f, 12, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[6]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[6]")).sendKeys(Text);
				}
				if(VEPNI7.equals("SI")) {
					String Text=getCellValueSString(f, 14, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[7]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[7]")).sendKeys(Text);
				}
				if(VEPNI8.equals("SI")) {
					String Text=getCellValueSString(f, 16, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[8]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[8]")).sendKeys(Text);
				}
				if(VEPNI9.equals("SI")) {
					String Text=getCellValueSString(f, 18, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[9]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[9]")).sendKeys(Text);
				}
				if(VEPNI10.equals("SI")) {
					String Text=getCellValueSString(f, 20, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[10]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[10]")).sendKeys(Text);
				}
				if(VEPNI11.equals("SI")) {
					String Text=getCellValueSString(f, 22, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[11]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[11]")).sendKeys(Text);
				}
				if(VEPNI12.equals("SI")) {
					String Text=getCellValueSString(f, 24, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[12]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[12]")).sendKeys(Text);
				}
				if(VEPNI13.equals("SI")) {
					String Text=getCellValueSString(f, 26, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[13]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[13]")).sendKeys(Text);
				}
				if(VEPNI14.equals("SI")) {
					String Text=getCellValueSString(f, 28, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[14]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[14]")).sendKeys(Text);
				}
				if(VEPNI15.equals("SI")) {
					String Text=getCellValueSString(f, 30, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[15]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[15]")).sendKeys(Text);
				}
				if(VEPNI16.equals("SI")) {
					String Text=getCellValueSString(f, 32, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[16]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[16]")).sendKeys(Text);
				}
				if(VEPNI17.equals("SI")) {
					String Text=getCellValueSString(f, 34, "AntecedentesMorbidos","Historia Clinica Pediatria");
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[17]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[17]")).sendKeys(Text);
				}
			}
			
			// Inmunizaciones
			String VPNI1 = getCellValueSString(g, 1, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI2 = getCellValueSString(g, 4, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI3 = getCellValueSString(g, 10, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI4 = getCellValueSString(g, 14, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI5 = getCellValueSString(g, 20, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI6 = getCellValueSString(g, 23, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI7 = getCellValueSString(g, 27, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI8 = getCellValueSString(g, 29, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI9 = getCellValueSString(g, 32, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI10 = getCellValueSString(g, 35, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI11 = getCellValueSString(g, 38, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI12 = getCellValueSString(g, 42, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			String VPNI13 = getCellValueSString(g, 45, "AntecedentesMorbidos", "Historia Clinica Pediatria");
			driver.findElement(OpcInmunizaciones).click();
			if (VPNI1.equals("") && VPNI2.equals("") && VPNI3.equals("") && VPNI4.equals("") && VPNI5.equals("")
					&& VPNI6.equals("") && VPNI7.equals("") && VPNI8.equals("") && VPNI9.equals("")
					&& VPNI10.equals("") && VPNI11.equals("") && VPNI12.equals("") && VPNI13.equals("")) {
				System.out.println("No hay datos en Vacunas Extras PNI");
				driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[8]")).click();
			}else {				
				if(VPNI1.equals("SI")) {
					String Opc=getCellValueSString(g, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(Opc.equals("X")|| Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[1]")).click();
					}
					String Text=getCellValueSString(g, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[1]")).sendKeys(Text);
					}			
				}
				if(VPNI2.equals("SI")) {
					String Opc1=getCellValueSString(g, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Opc2=getCellValueSString(g, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Opc3=getCellValueSString(g, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Opc4=getCellValueSString(g, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(Opc1.equals("X")|| Opc1.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[2]")).click();
					}
					if(Opc2.equals("X")|| Opc2.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[3]")).click();
					}
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[4]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[5]")).click();
					}
					String Text=getCellValueSString(g, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[2]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[2]")).sendKeys(Text);
					}			
				}
				if(VPNI3.equals("SI")) {
					String Opc3=getCellValueSString(g, 11, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Opc4=getCellValueSString(g, 12, "AntecedentesMorbidos","Historia Clinica Pediatria");				
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[6]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[7]")).click();
					}
					String Text=getCellValueSString(g, 13, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[3]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[3]")).sendKeys(Text);
					}			
				}
				if(VPNI4.equals("SI")) {
					String Opc1=getCellValueSString(g, 15, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Opc2=getCellValueSString(g, 16, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Opc3=getCellValueSString(g, 17, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Opc4=getCellValueSString(g, 18, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(Opc1.equals("X")|| Opc1.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[8]")).click();
					}
					if(Opc2.equals("X")|| Opc2.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[9]")).click();
					}
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[10]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[11]")).click();
					}
					String Text=getCellValueSString(g, 19, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[4]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[4]")).sendKeys(Text);
					}			
				}
				if (VPNI5.equals("SI")) {
					String Opc = getCellValueSString(g, 21, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[12]")).click();
					}
					String Text = getCellValueSString(g, 22, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[5]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[5]")).sendKeys(Text);
					}
				}
				if(VPNI6.equals("SI")) {
					String Opc = getCellValueSString(g, 24, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[13]")).click();
					}
					String Text = getCellValueSString(g, 25, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[6]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[6]")).sendKeys(Text);
					}
				}
				if(VPNI7.equals("SI")) {
					String Opc = getCellValueSString(g, 27, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[14]")).click();
					}
					String Text = getCellValueSString(g, 28, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[7]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[7]")).sendKeys(Text);
					}
				}
				if(VPNI8.equals("SI")) {
					String Opc = getCellValueSString(g, 30, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[15]")).click();
					}
					String Text = getCellValueSString(g, 31, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[8]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[8]")).sendKeys(Text);
					}
				}
				if(VPNI9.equals("SI")) {
					String Opc = getCellValueSString(g, 33, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[16]")).click();
					}
					String Text = getCellValueSString(g, 34, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[9]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[9]")).sendKeys(Text);
					}
				}
				if(VPNI10.equals("SI")) {
					String Opc = getCellValueSString(g, 36, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[17]")).click();
					}
					String Text = getCellValueSString(g, 37, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[10]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[10]")).sendKeys(Text);
					}
				}
				if(VPNI11.equals("SI")) {
					String Opc3=getCellValueSString(g, 39, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Opc4=getCellValueSString(g, 40, "AntecedentesMorbidos","Historia Clinica Pediatria");				
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[18]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[19]")).click();
					}
					String Text=getCellValueSString(g, 41, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[11]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[11]")).sendKeys(Text);
					}		
				}
				if(VPNI12.equals("SI")) {
					String Opc = getCellValueSString(g, 43, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[20]")).click();
					}
					String Text = getCellValueSString(g, 44, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[12]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[12]")).sendKeys(Text);
					}
				}
				if(VPNI13.equals("SI")) {
					String Opc3=getCellValueSString(g, 46, "AntecedentesMorbidos","Historia Clinica Pediatria");
					String Opc4=getCellValueSString(g, 47, "AntecedentesMorbidos","Historia Clinica Pediatria");				
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[21]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[22]")).click();
					}
					String Text=getCellValueSString(g, 48, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[13]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[13]")).sendKeys(Text);
					}		
				}
			}
			// H�bitos y Necesidades
			String EstadoDificultades = getCellValueSString(h, 1, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoAusencia = getCellValueSString(h, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoProblemas = getCellValueSString(h, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoHigieneoral = getCellValueSString(h, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoHigiene = getCellValueSString(h, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoTabaquismo = getCellValueSString(h, 11, "AntecedentesMorbidos","Historia Clinica Pediatria");
			
			if (EstadoHigiene.equals("") && EstadoTabaquismo.equals("") && EstadoHigieneoral.equals("") && EstadoProblemas.equals("")
					&& EstadoAusencia.equals("") && EstadoDificultades.equals("") ) {
				System.out.print("No hay datos en H�bitos y Necesidades");
			} else {
				Thread.sleep(500);
				driver.findElement(OpcHabitos).click();
				Thread.sleep(500);
				// DATOS Dificultades con el sue�o
				if (EstadoDificultades.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[85]")).click();				
					String Texto1 = getCellValueSString(h, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[40]")).sendKeys(Texto1);
						}
				} else if (EstadoDificultades.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[86]")).click();
				} else if (EstadoDificultades.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[87]")).click();
				}
				// DATOS Ausencia del control de esf�nteres
				if (EstadoAusencia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[88]")).click();					
					String Texto1 = getCellValueSString(h, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[41]")).sendKeys(Texto1);
						}
				} else if (EstadoAusencia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[89]")).click();
				} else if (EstadoAusencia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[90]")).click();
				}
				// DATOS Problemas con la alimentaci�n
				if (EstadoProblemas.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[91]")).click();					
					String Texto1 = getCellValueSString(h, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[42]")).sendKeys(Texto1);
						}
				} else if (EstadoProblemas.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[93]")).click();
				} else if (EstadoProblemas.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[94]")).click();
				}
				// DATOS Higiene oral > 2 veces al d�a
				if (EstadoHigieneoral.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[95]")).click();					
					String Texto1 = getCellValueSString(h, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[43]")).sendKeys(Texto1);
						}
				} else if (EstadoHigieneoral.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[96]")).click();
				} else if (EstadoHigieneoral.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[97]")).click();
				}
				// DATOS Higiene personal diaria
				if (EstadoHigiene.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[98]")).click();
					String Texto1 = getCellValueSString(h, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[44]")).sendKeys(Texto1);
						}
				} else if (EstadoHigiene.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[99]")).click();
				} else if (EstadoHigiene.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[100]")).click();
				}				
				// DATOS Tabaquismo
				if (EstadoTabaquismo.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[101]")).click();					
					String Texto1 = getCellValueSString(h, 12, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[45]")).sendKeys(Texto1);
						}
				} else if (EstadoTabaquismo.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[102]")).click();
				} else if (EstadoTabaquismo.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[103]")).click();
				}	
			}
			// Perinatales
						String OpcPerinatal1 = getCellValueSString(i, 1, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPerinatal2 = getCellValueSString(i, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPerinatal3 = getCellValueSString(i, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPerinatal4 = getCellValueSString(i, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPerinatal5 = getCellValueSString(i, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPerinatal6 = getCellValueSString(i, 11, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPerinatal7 = getCellValueSString(i, 16, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPerinatal8 = getCellValueSString(i, 19, "AntecedentesMorbidos","Historia Clinica Pediatria");
						if (OpcPerinatal1.equals("") && OpcPerinatal2.equals("") && OpcPerinatal3.equals("")
								&& OpcPerinatal4.equals("") && OpcPerinatal5.equals("") && OpcPerinatal6.equals("")
								&& OpcPerinatal7.equals("") && OpcPerinatal8.equals("")) {
							System.out.print("No hay datos en Perinatales");
						} else {							
							driver.findElement(OpcPerinatales).click();
							Thread.sleep(500);
							// DATOS Requiri� hospitalizaci�n
							if (OpcPerinatal1.equals("SI")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[103]")).click();
								String Texto1 = getCellValueSString(i, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[76]")).sendKeys(Texto1);	
								}								
							} else if (OpcPerinatal1.equals("NO")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[104]")).click();
								String Texto1 = getCellValueSString(i, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[76]")).sendKeys(Texto1);
								}		
							} else if (OpcPerinatal1.equals("DESCONOCE")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[105]")).click();
								String Texto1 = getCellValueSString(i, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[76]")).sendKeys(Texto1);
									}							
								}
							// DATOS Via de parto
							if (OpcPerinatal2.equals("VAGINAL")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[106]")).click();
								String Texto1 = getCellValueSString(i, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[77]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal2.equals("CESAREA")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[107]")).click();
								String Texto1 = getCellValueSString(i, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[77]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal2.equals("DESCONOCE")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[108]")).click();
								String Texto1 = getCellValueSString(i, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[77]")).sendKeys(Texto1);
									}
							}
							// DATOS Requiri� Oxigeno al nacer
							if (OpcPerinatal3.equals("SI")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[109]")).click();
								String Texto1 = getCellValueSString(i, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[78]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal3.equals("NO")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[110]")).click();
								String Texto1 = getCellValueSString(i, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[78]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal3.equals("DESCONOCE")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[111]")).click();
								String Texto1 = getCellValueSString(i, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[78]")).sendKeys(Texto1);
									}
								}
							// DATOS T�rmino de nacimiento
							if (OpcPerinatal4.equals("PRE T�RMINO")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[113]")).click();
								String Texto1 = getCellValueSString(i, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[79]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal4.equals("A T�RMINO")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[112]")).click();
								String Texto1 = getCellValueSString(i, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[79]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal4.equals("DESCONOCE")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[114]")).click();
								String Texto1 = getCellValueSString(i, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[79]")).sendKeys(Texto1);
									}
								}
							// DATOS Controles prenatales
							if (OpcPerinatal5.equals("SI")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[115]")).click();
								String Texto1 = getCellValueSString(i, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[80]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal5.equals("NO")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[116]")).click();
								String Texto1 = getCellValueSString(i, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[80]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal5.equals("DESCONOCE")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[117]")).click();
								String Texto1 = getCellValueSString(i, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[80]")).sendKeys(Texto1);
									}
								}
							// DATOS Peso y talla de nacimiento
							if (OpcPerinatal6.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(i, 12, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto2 = ""+getCellValuesInt(i, 13, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto3 = getCellValueSString(i, 14, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto4 = getCellValueSString(i, 15, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[36]")).sendKeys(Texto1);	
								}
								if(!Texto2.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[37]")).sendKeys(Texto2);	
								}
								if(Texto3.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[118]")).click();																	
								}													
								if(!Texto4.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[38]")).sendKeys(Texto4);	
								}
							}
							if (OpcPerinatal7.equals("SI")) {
								String Texto1 = ""+ getCellValuesInt(i, 17, "AntecedentesMorbidos", "Historia Clinica Pediatria");
								String Texto2 = getCellValueSString(i, 18, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if (!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[39]")).sendKeys(Texto1);
								}
								if (!Texto2.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[40]")).sendKeys(Texto2);
								}

							}
							if (OpcPerinatal8.equals("SI")) {
								String Texto1 = getCellValueSString(i, 20, "AntecedentesMorbidos", "Historia Clinica Pediatria");
								String Texto2 = getCellValueSString(i, 21, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto3 = getCellValueSString(i, 22, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if (!Texto1.equals("")) {
									if (Texto1.indexOf("-") != -1) {
										Texto1 = Texto1.replace("-", "/");
									}
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[41]")).sendKeys(Texto1+" "+Texto2);
								}
								if (!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[42]")).sendKeys(Texto3);
								}

							}
						}
						// Psicomotor
						String OpcPsicomotor1 = getCellValueSString(j, 1, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPsicomotor2 = getCellValueSString(j, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPsicomotor3 = getCellValueSString(j, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPsicomotor4 = getCellValueSString(j, 13, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPsicomotor5 = getCellValueSString(j, 17, "AntecedentesMorbidos","Historia Clinica Pediatria");
						String OpcPsicomotor6 = getCellValueSString(j, 21, "AntecedentesMorbidos","Historia Clinica Pediatria");
						if (OpcPsicomotor1.equals("") && OpcPsicomotor2.equals("") && OpcPsicomotor3.equals("")
								&& OpcPsicomotor4.equals("") && OpcPsicomotor5.equals("") && OpcPsicomotor6.equals("")) {
							System.out.print("No hay datos en Perinatales");
						} else {
							driver.findElement(OpcPsicomotor).click();
							Thread.sleep(500);
							// DATOS Sentarse sin ayuda
							if (OpcPsicomotor1.equals("SI")) {
								String Texto1 = ""+ getCellValuesInt(j, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto2 =getCellValueSString(j, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto3 = getCellValueSString(j, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[1]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[24]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[43]")).sendKeys(Texto3);
								}
							} 
							// Datos Sostenerse con ayuda
							if (OpcPsicomotor2.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(j, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto2 =getCellValueSString (j, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto3 = getCellValueSString(j, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[2]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[25]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[44]")).sendKeys(Texto3);
								}
							}  
							// Datos Gatear
							if (OpcPsicomotor3.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(j, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto2 = getCellValueSString(j, 11, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto3 = getCellValueSString(j, 12, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[3]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[26]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[45]")).sendKeys(Texto3);
								}
							}  
							// Datos Caminar con ayuda
							if (OpcPsicomotor4.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(j, 14, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto2 = getCellValueSString(j, 15, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto3 = getCellValueSString(j, 16, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[4]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[27]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[46]")).sendKeys(Texto3);
								}
							}  
							// Datos Sostenerse s�lo
							if (OpcPsicomotor5.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(j, 18, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto2 = getCellValueSString(j, 19, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto3 = getCellValueSString(j, 20, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[5]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[28]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[47]")).sendKeys(Texto3);
								}
							}  
							// Datos Caminado s�lo
							if (OpcPsicomotor6.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(j, 22, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto2 = getCellValueSString(j, 23, "AntecedentesMorbidos","Historia Clinica Pediatria");
								String Texto3 = getCellValueSString(j, 24, "AntecedentesMorbidos","Historia Clinica Pediatria");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[6]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[29]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[48]")).sendKeys(Texto3);
								}
							}
							
							// Alimentaci�n
							String OpcAlimentacion1 = getCellValueSString(k, 1, "AntecedentesMorbidos","Historia Clinica Pediatria");
							String OpcAlimentacion2 = getCellValueSString(k, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");
							String OpcAlimentacion3 = getCellValueSString(k, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
							String OpcAlimentacion4 = getCellValueSString(k, 10, "AntecedentesMorbidos","Historia Clinica Pediatria");
							if (OpcAlimentacion1.equals("") && OpcAlimentacion2.equals("") && OpcAlimentacion3.equals("")
									&& OpcAlimentacion4.equals("")) {
								System.out.print("No hay datos en Alimentacion");
							} else {
								WebElement element = driver.findElement(By.xpath("(//*[@class='dx-item-content dx-accordion-item-title'])[6]"));
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
								driver.findElement(OpcAlimentacion).click();
								Thread.sleep(500);
								// Datos Lactancia artificial
								if (OpcAlimentacion1.equals("Refiere")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[118]")).click();				
									String Texto1 =""+ getCellValuesInt(k, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto1.equals("")&&!Texto1.equals("0")) {									
										driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//textarea[@class='dx-texteditor-input'])[24]")).sendKeys(Texto1);
									}
									String Texto2 =getCellValueSString(k, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto2.equals("")) {
										driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[49]")).sendKeys(Texto2);
									}
								} else if (OpcAlimentacion1.equals("Niega")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[119]")).click();
								} else if (OpcAlimentacion1.equals("No evaluado")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[120]")).click();
								}

								// Datos Lactancia exlusiva
								if (OpcAlimentacion2.equals("Refiere")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[121]")).click();				
									String Texto1 =""+ getCellValuesInt(k, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto1.equals("")&&!Texto1.equals("0")) {
										driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//textarea[@class='dx-texteditor-input'])[25]")).sendKeys(Texto1);
									}
									String Texto2 =getCellValueSString(k, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto2.equals("")) {
										driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[50]")).sendKeys(Texto2);
									}
								} else if (OpcAlimentacion2.equals("Niega")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[122]")).click();
								} else if (OpcAlimentacion2.equals("No evaluado")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[123]")).click();
								}
								// Datos Alimentaci�n complemetaria
								if (OpcAlimentacion3.equals("Refiere")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[124]")).click();				
									String Texto1 =""+ getCellValuesInt(k, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto1.equals("")&&!Texto1.equals("0")) {
										driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//textarea[@class='dx-texteditor-input'])[26]")).sendKeys(Texto1);
									}
									String Texto2 =getCellValueSString(k, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto2.equals("")) {
										driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[51]")).sendKeys(Texto2);
									}
								} else if (OpcAlimentacion3.equals("Niega")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[125]")).click();
								} else if (OpcAlimentacion3.equals("No evaluado")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[126]")).click();
								}
								// Datos Intolerancia a alimentos
								if (OpcAlimentacion4.equals("Refiere")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[127]")).click();				
									String Texto1 =""+ getCellValuesInt(k, 11, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto1.equals("")&&!Texto1.equals("0")) {
										driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//textarea[@class='dx-texteditor-input'])[27]")).sendKeys(Texto1);
									}
									String Texto2 =getCellValueSString(k, 12, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto2.equals("")) {
										driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[52]")).sendKeys(Texto2);
									}
								} else if (OpcAlimentacion4.equals("Niega")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[128]")).click();
								} else if (OpcAlimentacion4.equals("No evaluado")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[129]")).click();
								}
							}
							// Epidemiologicos
							String OpcEpidemiologicos1 = getCellValueSString(l, 1, "AntecedentesMorbidos","Historia Clinica Pediatria");
							String OpcEpidemiologicos2 = getCellValueSString(l, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
							String OpcEpidemiologicos3 = getCellValueSString(l, 5, "AntecedentesMorbidos","Historia Clinica Pediatria");
							String OpcEpidemiologicos4 = getCellValueSString(l, 7, "AntecedentesMorbidos","Historia Clinica Pediatria");
							String OpcEpidemiologicos5 = getCellValueSString(l, 9, "AntecedentesMorbidos","Historia Clinica Pediatria");
							if (OpcEpidemiologicos1.equals("") && OpcEpidemiologicos2.equals("") && OpcEpidemiologicos3.equals("")
									&& OpcEpidemiologicos4.equals("")&& OpcEpidemiologicos5.equals("")) {
								System.out.print("No hay datos en Epidemiologicos");
							} else {
								driver.findElement(OpcEpidemiologicos).click();
								Thread.sleep(500);
								// Datos Lactancia artificial
								if (OpcEpidemiologicos1.equals("Refiere")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[130]")).click();				
									String Texto1 =getCellValueSString(l, 2, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto1.equals("")&&!Texto1.equals("0")) {
										driver.findElement(By.xpath("((//*[@class='dx-datagrid-rowsview dx-datagrid-nowrap'])/..//input[@class='dx-texteditor-input'])[46]")).sendKeys(Texto1);
									}									
								} else if (OpcEpidemiologicos1.equals("Niega")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[131]")).click();
								} else if (OpcEpidemiologicos1.equals("No evaluado")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[132]")).click();
								}

								// Datos Lactancia exlusiva
								if (OpcAlimentacion2.equals("Refiere")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[133]")).click();				
									String Texto1 =getCellValueSString(l, 4, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto1.equals("")&&!Texto1.equals("0")) {
										driver.findElement(By.xpath("((//*[@class='dx-datagrid-rowsview dx-datagrid-nowrap'])/..//input[@class='dx-texteditor-input'])[47]")).sendKeys(Texto1);
									}									
								} else if (OpcAlimentacion2.equals("Niega")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[134]")).click();
								} else if (OpcAlimentacion2.equals("No evaluado")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[135]")).click();
								}
								// Datos Alimentaci�n complemetaria
								if (OpcAlimentacion3.equals("Refiere")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[136]")).click();				
									String Texto1 =getCellValueSString(l, 6, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto1.equals("")&&!Texto1.equals("0")) {
										driver.findElement(By.xpath("((//*[@class='dx-datagrid-rowsview dx-datagrid-nowrap'])/..//input[@class='dx-texteditor-input'])[48]")).sendKeys(Texto1);
									}
								} else if (OpcAlimentacion3.equals("Niega")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[137]")).click();
								} else if (OpcAlimentacion3.equals("No evaluado")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[138]")).click();
								}
								// Datos Intolerancia a alimentos
								if (OpcAlimentacion4.equals("Refiere")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[139]")).click();				
									String Texto1 =getCellValueSString(l, 8, "AntecedentesMorbidos","Historia Clinica Pediatria");
									if(!Texto1.equals("")&&!Texto1.equals("0")) {
										driver.findElement(By.xpath("((//*[@class='dx-datagrid-rowsview dx-datagrid-nowrap'])/..//input[@class='dx-texteditor-input'])[49]")).sendKeys(Texto1);
									}
								} else if (OpcAlimentacion4.equals("Niega")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[140]")).click();
								} else if (OpcAlimentacion4.equals("No evaluado")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[141]")).click();
								}
							}
						}
	}
	
	public void AntecedentesMorbidosMFisica(WebDriver driver, int a, int b, int c, int d, int e, int f,int g,int h, int i, int j, int k,int l) throws InterruptedException, IOException {
		Thread.sleep(500);
		driver.findElement(OpcionAntecedentesMor).click();
		Thread.sleep(1000);
		// Antesedente M�dicos
					String EstadoHipertension = getCellValueSString(a, 1, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String EstadoCancer = getCellValueSString(a, 5, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String EstadoITU = getCellValueSString(a, 9, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String EstadoSindrome = getCellValueSString(a, 13, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String EstadoLeusemia = getCellValueSString(a, 17, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String EstadoDiabetes = getCellValueSString(a, 21, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String EstadoIRA = getCellValueSString(a, 25, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String EstadoAsma = getCellValueSString(a, 29, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String EstadoOtros = getCellValueSString(a, 33, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (EstadoHipertension.equals("") && EstadoCancer.equals("") && EstadoITU.equals("")
							&& EstadoSindrome.equals("") && EstadoLeusemia.equals("") && EstadoDiabetes.equals("")
							&& EstadoIRA.equals("") && EstadoAsma.equals("") && EstadoOtros.equals("")) {
						System.out.println("No se selecciono ningun Antesedente de M�dicos");
					} else {
						// DATOS HIPERTENSION ARTERIAL
						if (EstadoHipertension.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[1]")).click();
							String Condicion = getCellValueSString(a, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if (Condicion.equals("Activo")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[4]")).click();
							} else {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[5]")).click();
							}
							String Texto1 = getCellValueSString(a, 3, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							String Texto2 = getCellValueSString(a, 4, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if(!Texto1.equals("")) {
								Thread.sleep(500);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[1]")).sendKeys(Texto1);
							}
							if(!Texto2.equals("")) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[2]")).click();
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[2]")).sendKeys(Texto2);
							}					
						} else if (EstadoHipertension.equals("Niega")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[2]")).click();
						} else if (EstadoHipertension.equals("No evaluado")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[3]")).click();
						}
						// DATOS CANCER
						if (EstadoCancer.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[6]")).click();
							String Condicion = getCellValueSString(a, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if (Condicion.equals("Activo")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[9]")).click();
							} else {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[10]")).click();
							}
							String Texto1 = getCellValueSString(a, 7, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							String Texto2 = getCellValueSString(a, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");					
							if(!Texto1.equals("")) {
								Thread.sleep(500);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[3]")).sendKeys(Texto1);
							}
							if(!Texto2.equals("")) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[4]")).click();
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[4]")).sendKeys(Texto2);
							}					
						} else if (EstadoCancer.equals("Niega")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[7]")).click();
						} else if (EstadoCancer.equals("No evaluado")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[8]")).click();
						}
						// DATOS ITU
						if (EstadoITU.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[11]")).click();
							String Condicion = getCellValueSString(a, 10, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if (Condicion.equals("Activo")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[14]")).click();
							} else {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[15]")).click();
							}
							String Texto1 = getCellValueSString(a, 11, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							String Texto2 = getCellValueSString(a, 12, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");					
							if(!Texto1.equals("")) {
								Thread.sleep(500);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[5]")).sendKeys(Texto1);
							}
							if(!Texto2.equals("")) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[6]")).click();
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[6]")).sendKeys(Texto2);
							}					
						} else if (EstadoITU.equals("Niega")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[12]")).click();
						} else if (EstadoITU.equals("No evaluado")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[13]")).click();
						}
						// DATOS S�ndrome Diarreico
						if (EstadoSindrome.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[16]")).click();
							String Condicion = getCellValueSString(a, 14, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if (Condicion.equals("Activo")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[19]")).click();
							} else {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[20]")).click();
							}
							String Texto1 = getCellValueSString(a, 15, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							String Texto2 = getCellValueSString(a, 16, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if(!Texto1.equals("")) {
								Thread.sleep(500);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[7]")).sendKeys(Texto1);
							}
							if(!Texto2.equals("")) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[8]")).click();
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[8]")).sendKeys(Texto2);
							}					
						} else if (EstadoSindrome.equals("Niega")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[17]")).click();
						} else if (EstadoSindrome.equals("No evaluado")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[18]")).click();
						}
						// DATOS Leucemia
						if (EstadoLeusemia.equals("Refiere")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[21]")).click();
							String Condicion = getCellValueSString(a, 18, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if (Condicion.equals("Activo")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[24]")).click();
							} else {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[25]")).click();
							}
							String Texto1 = getCellValueSString(a, 19, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							String Texto2 = getCellValueSString(a, 20, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if(!Texto1.equals("")) {
								Thread.sleep(500);					
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[9]")).sendKeys(Texto1);						
							}
							if(!Texto2.equals("")) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[10]")).click();
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[10]")).sendKeys(Texto2);
							}					
						} else if (EstadoLeusemia.equals("Niega")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[22]")).click();
						} else if (EstadoLeusemia.equals("No evaluado")) {
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[23]")).click();
						}
						// DATOS DIABETES
						if (EstadoDiabetes.equals("Refiere")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]")).click();
							String Condicion = getCellValueSString(a, 22, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if (Condicion.equals("Activo")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[29]")).click();
							} else {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[30]")).click();
							}
							String Texto1 = getCellValueSString(a, 23, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							String Texto2 = getCellValueSString(a, 24, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if(!Texto1.equals("")) {
								Thread.sleep(500);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[11]")).sendKeys(Texto1);
							}
							if(!Texto2.equals("")) {
								Thread.sleep(1000);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[12]")).click();
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[12]")).sendKeys(Texto2);
							}					
						} else if (EstadoDiabetes.equals("Niega")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[27]")).click();
						} else if (EstadoDiabetes.equals("No evaluado")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[28]")).click();
						}
						// DATOS IRA
						if (EstadoIRA.equals("Refiere")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[31]")).click();
							String Condicion = getCellValueSString(a, 26, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if (Condicion.equals("Activo")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[34]")).click();
							} else {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[35]")).click();
							}
							String Texto1 = getCellValueSString(a, 27, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							String Texto2 = getCellValueSString(a, 28, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if(!Texto1.equals("")) {
							Thread.sleep(500);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[13]")).sendKeys(Texto1);
							}
							if(!Texto2.equals("")) {
							Thread.sleep(1000);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[14]")).click();
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[14]")).sendKeys(Texto2);
							}
						} else if (EstadoIRA.equals("Niega")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[32]")).click();
						} else if (EstadoIRA.equals("No evaluado")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[33]")).click();
						}
						// DATOS ASMA
						if (EstadoAsma.equals("Refiere")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[36]")).click();
							String Condicion = getCellValueSString(a, 30, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if (Condicion.equals("Activo")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[39]")).click();
							} else {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[40]")).click();
							}
							String Texto1 = getCellValueSString(a, 31, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							String Texto2 = getCellValueSString(a, 32, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if(!Texto1.equals("")) {
							Thread.sleep(500);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[15]")).sendKeys(Texto1);
							}
							if(!Texto2.equals("")) {
							Thread.sleep(1000);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[16]")).click();
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[16]")).sendKeys(Texto2);
							}
						} else if (EstadoAsma.equals("Niega")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[37]")).click();
						} else if (EstadoAsma.equals("No evaluado")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[38]")).click();
						}
						// DATOS OTROS
						if (EstadoOtros.equals("Refiere")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[41]")).click();
							String Condicion = getCellValueSString(a, 34, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if (Condicion.equals("Activo")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[44]")).click();
							} else {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[45]")).click();
							}
							String Texto1 = getCellValueSString(a, 35, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							String Texto2 = getCellValueSString(a, 36, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if(!Texto1.equals("")) {
							Thread.sleep(500);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[17]")).sendKeys(Texto1);
							}
							if(!Texto2.equals("")) {
							Thread.sleep(1000);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[18]")).click();
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[18]")).sendKeys(Texto2);
							}
						} else if (EstadoOtros.equals("Niega")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[42]")).click();
						} else if (EstadoOtros.equals("No evaluado")) {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[26]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[43]")).click();
						}
						Thread.sleep(500);
						WebElement element = driver.findElement(By.xpath("(//*[@class='dx-item-content dx-accordion-item-title'])[4]"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					}
			// Patol�gicos Quir�rgicos
			String Estadovesico = getCellValueSString(b, 1, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoHerniorrafia = getCellValueSString(b, 5, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoApendicectomia = getCellValueSString(b, 9, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoGastro = getCellValueSString(b, 13, "AntecedentesMorbidos","Historia Clinica Pediatria");
			String EstadoOtro = getCellValueSString(b, 17, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			if (Estadovesico.equals("") && EstadoHerniorrafia.equals("") && EstadoApendicectomia.equals("")
					&& EstadoGastro.equals("") && EstadoOtro.equals("")) {
				System.out.println("No se selecciono ningun Antesedente  Quir�rgicos");
			} else {
				WebElement element = driver.findElement(By.xpath("(//*[@class='dx-item-content dx-accordion-item-title'])[6]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(500);
				driver.findElement(OpcPatologicosQui).click();
				Thread.sleep(500);
				// Datos Anti reflujo vesicoureteral
				if (Estadovesico.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[46]")).click();
					String Condicion = getCellValueSString(b, 2, "AntecedentesMorbidos","Historia Clinica Medicina de Urgencia");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[2]")).click();
					}
					String Texto1 = getCellValueSString(b, 3, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(b, 4, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[19]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[1]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[1]")).sendKeys(Texto2);
					}
				} else if (Estadovesico.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[47]")).click();
				} else if (Estadovesico.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[48]")).click();
				}
				// DATOS Herniorrafia
				if (EstadoHerniorrafia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[49]")).click();
					String Condicion = getCellValueSString(b, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[3]")).click();
					}
					String Texto1 = getCellValueSString(b, 7, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(b, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[14]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[2]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[2]")).sendKeys(Texto2);
					}
				} else if (EstadoHerniorrafia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[50]")).click();
				} else if (EstadoHerniorrafia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[51]")).click();
				}
				// DATOS Apendicectom�a
				if (EstadoApendicectomia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[52]")).click();
					String Condicion = getCellValueSString(b, 10, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[4]")).click();
					}
					String Texto1 = getCellValueSString(b, 11, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(b, 12, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[15]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[3]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[3]")).sendKeys(Texto2);
					}
				} else if (EstadoApendicectomia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[53]")).click();
				} else if (EstadoApendicectomia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[54]")).click();
				}
				// DATOS Anti Reflujo gastroesof�gico
				if (EstadoGastro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[55]")).click();
					String Condicion = getCellValueSString(b, 14, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[5]")).click();
					}
					String Texto1 = getCellValueSString(b, 15, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(b, 16, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[16]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[4]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[4]")).sendKeys(Texto2);
					}
				} else if (EstadoGastro.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[56]")).click();
				} else if (EstadoGastro.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[57]")).click();
				}
				// DATOS Otros
				if (EstadoOtro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[58]")).click();
					String Condicion = getCellValueSString(b, 18, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[6]")).click();
					}
					String Texto1 = getCellValueSString(b, 19, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(b, 20, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[17]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[5]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[5]")).sendKeys(Texto2);
					}
				} else if (EstadoOtro.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[59]")).click();
				} else if (EstadoOtro.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[60]")).click();
				}
			}
			
			
			// Traum�ticos
			String EstadoTrauma = getCellValueSString(c, 1, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoFracturas = getCellValueSString(c, 5, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoViolencia = getCellValueSString(c, 9, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoHeridas = getCellValueSString(c, 13, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoOtros1 = getCellValueSString(c, 17, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			if (EstadoTrauma.equals("") && EstadoFracturas.equals("") && EstadoViolencia.equals("")
					&& EstadoHeridas.equals("") && EstadoOtros1.equals("")) {

			} else {
				Thread.sleep(500);
				driver.findElement(OpcTraumaticos).click();
				Thread.sleep(500);
				// Datos Anti reflujo vesicoureteral
				if (EstadoTrauma.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[61]")).click();
					String Condicion = getCellValueSString(c, 3, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[7]")).click();
					}
					String Texto1 = getCellValueSString(c, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(c, 4, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[6]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[7]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[7]")).sendKeys(Texto2);
					}
				} else if (EstadoTrauma.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[62]")).click();
				} else if (EstadoTrauma.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[63]")).click();
				}
				// DATOS Herniorrafia
				if (EstadoFracturas.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[64]")).click();
					String Condicion = getCellValueSString(c, 7, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[8]")).click();
					}
					String Texto1 = getCellValueSString(c, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(c, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[8]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[9]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[9]")).sendKeys(Texto2);
					}
				} else if (EstadoFracturas.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[65]")).click();
				} else if (EstadoFracturas.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[66]")).click();
				}
				// DATOS Apendicectom�a
				if (EstadoViolencia.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[67]")).click();
					String Condicion = getCellValueSString(c, 11, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[9]")).click();
					}
					String Texto1 = getCellValueSString(c, 10, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(c, 12, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {					
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[10]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[11]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[11]")).sendKeys(Texto2);
					}
				} else if (EstadoViolencia.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[68]")).click();
				} else if (EstadoViolencia.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[69]")).click();
				}
				// DATOS Anti Reflujo gastroesof�gico
				if (EstadoHeridas.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[70]")).click();
					String Condicion = getCellValueSString(c, 15, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[10]")).click();
					}
					String Texto1 = getCellValueSString(c, 14, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(c, 16, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[12]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[13]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[13]")).sendKeys(Texto2);
					}
				} else if (EstadoHeridas.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[71]")).click();
				} else if (EstadoHeridas.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[72]")).click();
				}
				// DATOS Otros
				if (EstadoOtros1.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[73]")).click();
					String Condicion = getCellValueSString(c, 19, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[11]")).click();
					}
					String Texto1 = getCellValueSString(c, 18, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(c, 20, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
					Thread.sleep(500);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[14]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[15]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[15]")).sendKeys(Texto2);
					}
				} else if (EstadoOtros1.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[74]")).click();
				} else if (EstadoOtros1.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[75]")).click();
				}
			}
			// Al�rgicos
			String EstadoMedicamento = getCellValueSString(d, 1, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoAlimento = getCellValueSString(d, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoYodo = getCellValueSString(d, 11, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoLatex= getCellValueSString(d, 16, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoOtros2 = getCellValueSString(d, 21, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			if (EstadoMedicamento.equals("")  && EstadoAlimento.equals("")
					&& EstadoYodo.equals("") && EstadoOtros2.equals("")&& EstadoLatex.equals("")) {

			} else {
				Thread.sleep(500);
				driver.findElement(OpcAlergicos).click();
				Thread.sleep(500);
				// Datos Latex
				if (EstadoLatex.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[76]")).click();
					Thread.sleep(500);
					String Texto1 = getCellValueSString(d,17, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(d, 18, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[16]")).sendKeys(Texto1);
						Thread.sleep(300);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[17]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[17]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 19, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");					
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[12]")).click();
					}										
					String Texto3 = getCellValueSString(d, 20, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");										
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[18]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[18]")).sendKeys(Texto3);
					}
				} else if (EstadoLatex.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[77]")).click();
				} else if (EstadoLatex.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[78]")).click();
				}	
				// Datos Medicamentos
				if (EstadoMedicamento.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[79]")).click();
					Thread.sleep(500);
					String Texto1 = getCellValueSString(d, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(d, 3, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[19]")).sendKeys(Texto1);
						Thread.sleep(300);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[20]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[20]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 4, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");					
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[13]")).click();
					}										
					String Texto3 = getCellValueSString(d, 5, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");										
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[21]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[21]")).sendKeys(Texto3);
					}
				} else if (EstadoMedicamento.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[80]")).click();
				} else if (EstadoMedicamento.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[81]")).click();
				}			
				// DATOS Alimentos
				if (EstadoAlimento.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[82]")).click();
					String Texto1 = getCellValueSString(d, 7, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(d, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[22]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {					
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[23]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[23]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 9, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[14]")).click();
					}
					Thread.sleep(500);					
					String Texto3 = getCellValueSString(d, 10, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[24]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[24]")).sendKeys(Texto3);
					}
				} else if (EstadoAlimento.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[83]")).click();
				} else if (EstadoAlimento.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[84]")).click();
				}
				// DATOS Yodo
				if (EstadoYodo.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[85]")).click();
					String Texto1 = getCellValueSString(d, 17, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(d, 18, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[25]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[26]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[26]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 19, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[15]")).click();
					}					
					String Texto3 = getCellValueSString(d, 20, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[27]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[27]")).sendKeys(Texto3);
					}
				} else if (EstadoYodo.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[86]")).click();
				} else if (EstadoYodo.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[87]")).click();
				}
				// DATOS Otros
				if (EstadoOtros2.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[88]")).click();
					String Texto1 = getCellValueSString(d, 22, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(d, 23, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[28]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {					
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[29]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[29]")).sendKeys(Texto2);
						}
					String Condicion = getCellValueSString(d, 24, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[16]")).click();
					}									
					String Texto3 = getCellValueSString(d, 25, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[30]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[30]")).sendKeys(Texto3);
					}
				} else if (EstadoOtros2.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[89]")).click();
				} else if (EstadoOtros2.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[90]")).click();
				}
			}
			// Farmacol�gicos
			String EstadoMedicamentoAlo = getCellValueSString(e, 1, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoOxigeno = getCellValueSString(e, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoMedicamentosHome = getCellValueSString(e, 11, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String EstadoOtros3 = getCellValueSString(e, 16, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");

			if (EstadoMedicamentoAlo.equals("") && EstadoOxigeno.equals("") && EstadoMedicamentosHome.equals("")
					&& EstadoOtros3.equals("")) {

			} else {
				Thread.sleep(500);
				driver.findElement(OpcFarma).click();
				Thread.sleep(500);
				// Datos Medicamentos
				if (EstadoMedicamentoAlo.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[91]")).click();
					String Texto1 = getCellValueSString(e, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(e, 3, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[31]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[32]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[32]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 4, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[17]")).click();
					}					
					String Texto3 = getCellValueSString(e, 5, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					Thread.sleep(500);					
					if(!Texto2.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[33]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[33]")).sendKeys(Texto3);
					}
				} else if (EstadoMedicamentoAlo.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[92]")).click();
				} else if (EstadoMedicamentoAlo.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[93]")).click();
				}
				// DATOS Latex
				if (EstadoOxigeno.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[94]")).click();
					String Texto1 = getCellValueSString(e, 7, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(e, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[34]")).sendKeys(Texto1);
					}
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[35]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[35]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 9, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[18]")).click();
					}					
					String Texto3 = getCellValueSString(e, 10, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[36]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[36]")).sendKeys(Texto3);
					}
				} else if (EstadoOxigeno.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[95]")).click();
				} else if (EstadoOxigeno.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[96]")).click();
				}
				// DATOS Alimentos
				if (EstadoMedicamentosHome.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[97]")).click();
					String Texto1 = getCellValueSString(e, 12, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(e, 13, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[37]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[38]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[38]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 14, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[19]")).click();
					}				
					String Texto3 = getCellValueSString(e, 15, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					Thread.sleep(500);					
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[39]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[39]")).sendKeys(Texto3);
					}
				} else if (EstadoMedicamentosHome.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[98]")).click();
				} else if (EstadoMedicamentosHome.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[99]")).click();
				}
				// DATOS Otros
				if (EstadoOtros3.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[100]")).click();
					String Texto1 = getCellValueSString(e, 17, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Texto2 = getCellValueSString(e, 18, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Texto1.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[40]")).sendKeys(Texto1);
					}
					if(!Texto2.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[41]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[41]")).sendKeys(Texto2);
					}
					String Condicion = getCellValueSString(e, 19, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Condicion.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-switch-container'])/..//div[@class='dx-switch-off'])[20]")).click();
					}					
					String Texto3 = getCellValueSString(e, 20, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					Thread.sleep(500);	
					if(!Texto3.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[42]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[42]")).sendKeys(Texto3);
					}
				} else if (EstadoOtros3.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[101]")).click();
				} else if (EstadoOtros3.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[102]")).click();
				}
			}
			// Inmunizaciones 
			String VEPNI1 = getCellValueSString(f, 1, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI2 = getCellValueSString(f, 3, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI3 = getCellValueSString(f, 5, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI4 = getCellValueSString(f, 7, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI5 = getCellValueSString(f, 9, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI6 = getCellValueSString(f, 11, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI7 = getCellValueSString(f, 13, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI8 = getCellValueSString(f, 15, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI9 = getCellValueSString(f, 17, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI10 = getCellValueSString(f, 19, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI11 = getCellValueSString(f, 21, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI12 = getCellValueSString(f, 23, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI13 = getCellValueSString(f, 25, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI14 = getCellValueSString(f, 27, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI15 = getCellValueSString(f, 29, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI16 = getCellValueSString(f, 31, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			String VEPNI17 = getCellValueSString(f, 33, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
			driver.findElement(OpcInmunizaciones).click();
			Thread.sleep(500);	
			if (VEPNI1.equals("") && VEPNI2.equals("") && VEPNI3.equals("") && VEPNI4.equals("") && VEPNI5.equals("")
					&& VEPNI6.equals("") && VEPNI7.equals("") && VEPNI8.equals("") && VEPNI9.equals("")
					&& VEPNI10.equals("") && VEPNI11.equals("") && VEPNI12.equals("") && VEPNI13.equals("")
					&& VEPNI14.equals("") && VEPNI15.equals("") && VEPNI16.equals("") && VEPNI17.equals("")) {				
				System.out.println("No hay datos en Vacunas Extras PNI");
				WebElement element = driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[5]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(500);	
				driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[8]")).click();
			}else {		
				if(VEPNI1.equals("SI")) {
					String Text=getCellValueSString(f, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[1]")).sendKeys(Text);
					}					
				}
				if(VEPNI2.equals("SI")) {
					String Text=getCellValueSString(f, 4, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[2]")).sendKeys(Text);
					}
				}
				if(VEPNI3.equals("SI")) {
					String Text=getCellValueSString(f, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[3]")).sendKeys(Text);
					}
				}
				if(VEPNI4.equals("SI")) {
					String Text=getCellValueSString(f, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[4]")).sendKeys(Text);
					}
				}
				if(VEPNI5.equals("SI")) {
					String Text=getCellValueSString(f, 10, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[5]")).sendKeys(Text);
					}
				}
				if(VEPNI6.equals("SI")) {
					String Text=getCellValueSString(f, 12, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[6]")).sendKeys(Text);
					}
				}
				if(VEPNI7.equals("SI")) {
					String Text=getCellValueSString(f, 14, "AntecedentesMorbidos","Historia Clinica Pediatria");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[7]")).sendKeys(Text);
					}
				}
				if(VEPNI8.equals("SI")) {
					String Text=getCellValueSString(f, 16, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[8]")).sendKeys(Text);
					}
				}
				if(VEPNI9.equals("SI")) {
					String Text=getCellValueSString(f, 18, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[9]")).sendKeys(Text);
					}
				}
				if(VEPNI10.equals("SI")) {
					String Text=getCellValueSString(f, 20, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[10]")).sendKeys(Text);
					}
				}
				if(VEPNI11.equals("SI")) {
					String Text=getCellValueSString(f, 22, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[11]")).sendKeys(Text);
					}
				}
				if(VEPNI12.equals("SI")) {
					String Text=getCellValueSString(f, 24, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[12]")).sendKeys(Text);
					}
				}
				if(VEPNI13.equals("SI")) {
					String Text=getCellValueSString(f, 26, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[13]")).sendKeys(Text);
					}
				}
				if(VEPNI14.equals("SI")) {
					String Text=getCellValueSString(f, 28, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[14]")).sendKeys(Text);
					}
				}
				if(VEPNI15.equals("SI")) {
					String Text=getCellValueSString(f, 30, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[15]")).sendKeys(Text);
					}
				}
				if(VEPNI16.equals("SI")) {
					String Text=getCellValueSString(f, 32, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[16]")).sendKeys(Text);
					}
				}
				if(VEPNI17.equals("SI")) {
					String Text=getCellValueSString(f, 34, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[6]//../input)[17]")).sendKeys(Text);
					}
				}
				WebElement element = driver.findElement(OpcionPielFaneras);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(300);
				driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[8]")).click();				
			}
			
			// Inmunizaciones
			String VPNI1 = getCellValueSString(g, 1, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI2 = getCellValueSString(g, 4, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI3 = getCellValueSString(g, 10, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI4 = getCellValueSString(g, 14, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI5 = getCellValueSString(g, 20, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI6 = getCellValueSString(g, 23, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI7 = getCellValueSString(g, 26, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI8 = getCellValueSString(g, 29, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI9 = getCellValueSString(g, 32, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI10 = getCellValueSString(g, 35, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI11 = getCellValueSString(g, 38, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI12 = getCellValueSString(g, 42, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			String VPNI13 = getCellValueSString(g, 45, "AntecedentesMorbidos", "Historia Clinica Medicina Fisica");
			driver.findElement(OpcInmunizaciones).click();
			if (VPNI1.equals("") && VPNI2.equals("") && VPNI3.equals("") && VPNI4.equals("") && VPNI5.equals("")
					&& VPNI6.equals("") && VPNI7.equals("") && VPNI8.equals("") && VPNI9.equals("")
					&& VPNI10.equals("") && VPNI11.equals("") && VPNI12.equals("") && VPNI13.equals("")) {
				System.out.println("No hay datos en Vacunas Extras PNI");
				WebElement element = driver.findElement(OpcionPielFaneras);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(300);
				driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[9]")).click();
			}else {				
				if(VPNI1.equals("SI")) {
					String Opc=getCellValueSString(g, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(Opc.equals("X")|| Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[1]")).click();
					}
					String Text=getCellValueSString(g, 3, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[1]")).sendKeys(Text);
					}			
				}
				if(VPNI2.equals("SI")) {
					String Opc1=getCellValueSString(g, 5, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Opc2=getCellValueSString(g, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Opc3=getCellValueSString(g, 7, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Opc4=getCellValueSString(g, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(Opc1.equals("X")|| Opc1.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[2]")).click();
					}
					if(Opc2.equals("X")|| Opc2.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[3]")).click();
					}
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[4]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[5]")).click();
					}
					String Text=getCellValueSString(g, 9, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[2]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[2]")).sendKeys(Text);
					}			
				}
				if(VPNI3.equals("SI")) {
					String Opc3=getCellValueSString(g, 11, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Opc4=getCellValueSString(g, 12, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");				
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[6]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[7]")).click();
					}
					String Text=getCellValueSString(g, 13, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[3]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[3]")).sendKeys(Text);
					}			
				}
				if(VPNI4.equals("SI")) {
					String Opc1=getCellValueSString(g, 15, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Opc2=getCellValueSString(g, 16, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Opc3=getCellValueSString(g, 17, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Opc4=getCellValueSString(g, 18, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(Opc1.equals("X")|| Opc1.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[8]")).click();
					}
					if(Opc2.equals("X")|| Opc2.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[9]")).click();
					}
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[10]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[11]")).click();
					}
					String Text=getCellValueSString(g, 19, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[4]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[4]")).sendKeys(Text);
					}			
				}
				if (VPNI5.equals("SI")) {
					String Opc = getCellValueSString(g, 21, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[12]")).click();
					}
					String Text = getCellValueSString(g, 22, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[5]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[5]")).sendKeys(Text);
					}
				}
				if(VPNI6.equals("SI")) {
					String Opc = getCellValueSString(g, 24, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[13]")).click();
					}
					String Text = getCellValueSString(g, 25, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[6]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[6]")).sendKeys(Text);
					}
				}
				if(VPNI7.equals("SI")) {
					String Opc = getCellValueSString(g, 27, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[14]")).click();
					}
					String Text = getCellValueSString(g, 28, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[7]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[7]")).sendKeys(Text);
					}
				}
				if(VPNI8.equals("SI")) {
					String Opc = getCellValueSString(g, 30, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[15]")).click();
					}
					String Text = getCellValueSString(g, 31, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[8]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[8]")).sendKeys(Text);
					}
				}
				if(VPNI9.equals("SI")) {
					String Opc = getCellValueSString(g, 33, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[16]")).click();
					}
					String Text = getCellValueSString(g, 34, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[9]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[9]")).sendKeys(Text);
					}
				}
				if(VPNI10.equals("SI")) {
					String Opc = getCellValueSString(g, 36, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[17]")).click();
					}
					String Text = getCellValueSString(g, 37, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[10]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[10]")).sendKeys(Text);
					}
				}
				if(VPNI11.equals("SI")) {
					String Opc3=getCellValueSString(g, 39, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Opc4=getCellValueSString(g, 40, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");				
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[18]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[19]")).click();
					}
					String Text=getCellValueSString(g, 41, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[11]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[11]")).sendKeys(Text);
					}		
				}
				if(VPNI12.equals("SI")) {
					String Opc = getCellValueSString(g, 43, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (Opc.equals("X") || Opc.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[20]")).click();
					}
					String Text = getCellValueSString(g, 44, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if (!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[12]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[12]")).sendKeys(Text);
					}
				}
				if(VPNI13.equals("SI")) {
					String Opc3=getCellValueSString(g, 46, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					String Opc4=getCellValueSString(g, 47, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");				
					if(Opc3.equals("X")|| Opc3.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[21]")).click();
					}
					if(Opc4.equals("X")|| Opc4.equals("x")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div[@class='dx-checkbox-container']/span[1])[22]")).click();
					}
					String Text=getCellValueSString(g, 48, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
					if(!Text.equals("")) {
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[13]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-datagrid-content'])[7]//../div/input)[13]")).sendKeys(Text);
					}		
				}
			}
			// H�bitos y Necesidades
						String EstadoHigiene = getCellValueSString(h, 1, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String EstadoEjercicio = getCellValueSString(h, 3, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String EstadoDependencia = getCellValueSString(h, 5, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String EstadoTabaquismo = getCellValueSString(h, 7, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String EstadoHigieneoral = getCellValueSString(h, 9, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String EstadoProblemas = getCellValueSString(h, 11, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String EstadoAusencia = getCellValueSString(h, 13, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String EstadoDificultades = getCellValueSString(h, 15, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String EstadoAlcohol = getCellValueSString(h, 17, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String EstadoDrogas = getCellValueSString(h, 19, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String EstadoOtro4 = getCellValueSString(h, 21, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						if (EstadoHigiene.equals("") && EstadoEjercicio.equals("") && EstadoDependencia.equals("")
								&& EstadoTabaquismo.equals("") && EstadoHigieneoral.equals("") && EstadoProblemas.equals("")
								&& EstadoAusencia.equals("") && EstadoDificultades.equals("") && EstadoAlcohol.equals("")
								&& EstadoDrogas.equals("") && EstadoOtro4.equals("")) {

						} else {
							WebElement element = driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[4]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
							Thread.sleep(500);
							driver.findElement(OpcHabitos).click();
							Thread.sleep(500);
							// DATOS Higiene personal diaria
							if (EstadoHigiene.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[103]")).click();
								String Texto1 = getCellValueSString(h, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[43]")).sendKeys(Texto1);
								}
							} else if (EstadoHigiene.equals("Niega")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[104]")).click();
							} else if (EstadoHigiene.equals("No evaluado")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[105]")).click();
							}
							// DATOS Ejercicio
							if (EstadoEjercicio.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[106]")).click();
								String Texto1 = getCellValueSString(h, 4, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[44]")).sendKeys(Texto1);
								}
							} else if (EstadoEjercicio.equals("Niega")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[107]")).click();
							} else if (EstadoEjercicio.equals("No evaluado")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[108]")).click();
							}
							// DATOS Dependencia al cuidador primario
							if (EstadoDependencia.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[109]")).click();					
								String Texto1 = getCellValueSString(h, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[45]")).sendKeys(Texto1);
								}
							} else if (EstadoDependencia.equals("Niega")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[110]")).click();
							} else if (EstadoDependencia.equals("No evaluado")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[111]")).click();
							}
							// DATOS Tabaquismo
							if (EstadoTabaquismo.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[112]")).click();					
								String Texto1 = getCellValueSString(h, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[46]")).sendKeys(Texto1);
								}
							} else if (EstadoTabaquismo.equals("Niega")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[113]")).click();
							} else if (EstadoTabaquismo.equals("No evaluado")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[114]")).click();
							}
							// DATOS Higiene oral > 2 veces al d�a
							if (EstadoHigieneoral.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[115]")).click();					
								String Texto1 = getCellValueSString(h, 10, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[47]")).sendKeys(Texto1);
								}
							} else if (EstadoHigieneoral.equals("Niega")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[116]")).click();
							} else if (EstadoHigieneoral.equals("No evaluado")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[117]")).click();
							}
							// DATOS Problemas con la alimentaci�n
							if (EstadoProblemas.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[118]")).click();					
								String Texto1 = getCellValueSString(h, 12, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[48]")).sendKeys(Texto1);
								}
							} else if (EstadoProblemas.equals("Niega")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[119]")).click();
							} else if (EstadoProblemas.equals("No evaluado")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]")).click();
							}
							// DATOS Ausencia del control de esf�nteres
							if (EstadoAusencia.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[121]")).click();					
								String Texto1 = getCellValueSString(h, 14, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[49]")).sendKeys(Texto1);
								}
							} else if (EstadoAusencia.equals("Niega")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[122]")).click();
							} else if (EstadoAusencia.equals("No evaluado")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[123]")).click();
							}
							// DATOS Dificultades con el sue�o
							if (EstadoDificultades.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[124]")).click();				
								String Texto1 = getCellValueSString(h, 16, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[50]")).sendKeys(Texto1);
								}
							} else if (EstadoDificultades.equals("Niega")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[125]")).click();
							} else if (EstadoDificultades.equals("No evaluado")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[126]")).click();
							}
							// DATOS Alcohol
							if (EstadoAlcohol.equals("Refiere")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[127]")).click();					
								String Texto1 = getCellValueSString(h, 18, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[51]")).sendKeys(Texto1);
								}
							} else if (EstadoAlcohol.equals("Niega")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[128]")).click();
							} else if (EstadoAlcohol.equals("No evaluado")) {
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[129]")).click();
							}
							// DATOS Drogas Recreativas
							if (EstadoDrogas.equals("Refiere")) {
								WebElement element1 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[130]")).click();					
								String Texto1 = getCellValueSString(h, 20, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[52]")).sendKeys(Texto1);
								}
							} else if (EstadoDrogas.equals("Niega")) {
								WebElement element2 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[131]")).click();
							} else if (EstadoDrogas.equals("No evaluado")) {
								WebElement element3 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[132]")).click();
							}
							// DATOS Otros
							if (EstadoOtro4.equals("Refiere")) {
								WebElement element4 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[133]")).click();				
								String Texto1 = getCellValueSString(h, 22, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[53]")).sendKeys(Texto1);
								}
							} else if (EstadoOtro4.equals("Niega")) {
								WebElement element5 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element5);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[134]")).click();
							} else if (EstadoOtro4.equals("No evaluado")) {
								WebElement element6 = driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]"));
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element6);
								driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[135]")).click();
							}
							Thread.sleep(500);
							WebElement element7 = driver.findElement(By.xpath("(//*[@class='dx-item-content dx-accordion-item-title'])[3]"));
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element7);
			// Perinatales
						String OpcPerinatal1 = getCellValueSString(i, 1, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPerinatal2 = getCellValueSString(i, 3, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPerinatal3 = getCellValueSString(i, 5, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPerinatal4 = getCellValueSString(i, 7, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPerinatal5 = getCellValueSString(i, 9, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPerinatal6 = getCellValueSString(i, 11, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPerinatal7 = getCellValueSString(i, 16, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPerinatal8 = getCellValueSString(i, 19, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						if (OpcPerinatal1.equals("") && OpcPerinatal2.equals("") && OpcPerinatal3.equals("")
								&& OpcPerinatal4.equals("") && OpcPerinatal5.equals("") && OpcPerinatal6.equals("")
								&& OpcPerinatal7.equals("") && OpcPerinatal8.equals("")) {
							System.out.print("No hay datos en Perinatales");
						} else {							
							driver.findElement(OpcPerinatales).click();
							Thread.sleep(500);
							// DATOS Requiri� hospitalizaci�n
							if (OpcPerinatal1.equals("SI")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[136]")).click();
								String Texto1 = getCellValueSString(i, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[84]")).sendKeys(Texto1);	
								}								
							} else if (OpcPerinatal1.equals("NO")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[1137]")).click();
								String Texto1 = getCellValueSString(i, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[84]")).sendKeys(Texto1);
								}		
							} else if (OpcPerinatal1.equals("DESCONOCE")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[138]")).click();
								String Texto1 = getCellValueSString(i, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[84]")).sendKeys(Texto1);
									}							
								}
							// DATOS Via de parto
							/*if (OpcPerinatal2.equals("VAGINAL")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[139]")).click();*/
								
							/*} else if (OpcPerinatal2.equals("CESAREA")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[140]")).click();
								String Texto1 = getCellValueSString(i, 4, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[85]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal2.equals("DESCONOCE")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[141]")).click();
								String Texto1 = getCellValueSString(i, 4, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[85]")).sendKeys(Texto1);
									}
							}*/
							String Texto5 = getCellValueSString(i, 4, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
							if(!Texto5.equals("")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[85]")).sendKeys(Texto5);
								}
							// DATOS Requiri� Oxigeno al nacer
							if (OpcPerinatal3.equals("SI")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[139]")).click();
								String Texto1 = getCellValueSString(i, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[86]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal3.equals("NO")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[140]")).click();
								String Texto1 = getCellValueSString(i, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[86]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal3.equals("DESCONOCE")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[141]")).click();
								String Texto1 = getCellValueSString(i, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[86]")).sendKeys(Texto1);
									}
								}
							// DATOS Término de nacimiento
							//if (OpcPerinatal4.equals("PRE TÉRMINO")) {
							//	driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[113]")).click();
								String Texto6 = getCellValueSString(i, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto6.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[87]")).sendKeys(Texto6);
									}
								/*} else if (OpcPerinatal4.equals("A TÉRMINO")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[112]")).click();
								String Texto1 = getCellValueSString(i, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("(((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[87]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal4.equals("DESCONOCE")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[114]")).click();
								String Texto1 = getCellValueSString(i, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[87]")).sendKeys(Texto1);
									}
								}*/
							// DATOS Controles prenatales
							if (OpcPerinatal5.equals("SI")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[142]")).click();
								String Texto1 = getCellValueSString(i, 10, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[88]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal5.equals("NO")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[143]")).click();
								String Texto1 = getCellValueSString(i, 10, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[88]")).sendKeys(Texto1);
									}
							} else if (OpcPerinatal5.equals("DESCONOCE")) {
								driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[144]")).click();
								String Texto1 = getCellValueSString(i, 10, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[88]")).sendKeys(Texto1);
									}
								}
							// DATOS Peso y talla de nacimiento
							if (OpcPerinatal6.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(i, 12, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto2 = ""+getCellValuesInt(i, 13, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto3 = getCellValueSString(i, 14, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto4 = getCellValueSString(i, 15, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[89]")).sendKeys(Texto1);	
								}
								if(!Texto2.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[90]")).sendKeys(Texto2);	
								}
								if(Texto3.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='col-12 text-center'])[2]/dx-check-box")).click();																	
								}													
								if(!Texto4.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[91]")).sendKeys(Texto4);	
								}
							}						
						}
						// Psicomotor
						String OpcPsicomotor1 = getCellValueSString(j, 1, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPsicomotor2 = getCellValueSString(j, 5, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPsicomotor3 = getCellValueSString(j, 9, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPsicomotor4 = getCellValueSString(j, 13, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPsicomotor5 = getCellValueSString(j, 17, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						String OpcPsicomotor6 = getCellValueSString(j, 21, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
						if (OpcPsicomotor1.equals("") && OpcPsicomotor2.equals("") && OpcPsicomotor3.equals("")
								&& OpcPsicomotor4.equals("") && OpcPsicomotor5.equals("") && OpcPsicomotor6.equals("")) {
							System.out.print("No hay datos en Perinatales");
						} else {
							driver.findElement(OpcPsicomotor).click();
							Thread.sleep(500);
							// DATOS Sentarse sin ayuda
							if (OpcPsicomotor1.equals("SI")) {
								String Texto1 = ""+ getCellValuesInt(j, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto2 =getCellValueSString(j, 3, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto3 = getCellValueSString(j, 4, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")&&!Texto1.equals("0")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[1]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[24]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//input[@class='dx-texteditor-input'])[39]")).sendKeys(Texto3);
								}
							} 
							// Datos Sostenerse con ayuda
							if (OpcPsicomotor2.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(j, 6, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto2 =getCellValueSString (j, 7, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto3 = getCellValueSString(j, 8, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")&&!Texto1.equals("0")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[2]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[25]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[40]")).sendKeys(Texto3);
								}
							}
							// Datos Gatear
							if (OpcPsicomotor3.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(j, 10, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto2 = getCellValueSString(j, 11, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto3 = getCellValueSString(j, 12, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")&&!Texto1.equals("0")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[3]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[26]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[41]")).sendKeys(Texto3);
								}
							}  
							// Datos Caminar con ayuda
							if (OpcPsicomotor4.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(j, 14, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto2 = getCellValueSString(j, 15, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto3 = getCellValueSString(j, 16, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")&&!Texto1.equals("0")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[4]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[27]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[42]")).sendKeys(Texto3);
								}
							}  
							// Datos Sostenerse sólo
							if (OpcPsicomotor5.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(j, 18, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto2 = getCellValueSString(j, 19, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto3 = getCellValueSString(j, 20, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[5]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[28]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[43]")).sendKeys(Texto3);
								}
							}  
							// Datos Caminado sólo
							if (OpcPsicomotor6.equals("SI")) {
								String Texto1 = ""+getCellValuesInt(j, 22, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto2 = getCellValueSString(j, 23, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								String Texto3 = getCellValueSString(j, 24, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
								if(!Texto1.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//textarea[@class='dx-texteditor-input'])[6]")).sendKeys(Texto1);
								}
								if(Texto2.equals("SI")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-checkbox-container'])[29]")).click();
								}
								if(!Texto3.equals("")) {
									driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[44]")).sendKeys(Texto3);
								}
							}
						}
							// Alimentación
							String OpcAlimentacion1 = getCellValueSString(k, 1, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");							
							if (OpcAlimentacion1.equals("")) {
								System.out.print("No hay datos en Alimentacion");
							} else {
								driver.findElement(OpcAlimentacion).click();
								Thread.sleep(500);
								// Datos Lactancia artificial
								if (OpcAlimentacion1.equals("Refiere")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[145]")).click();				
									String Texto1 =""+ getCellValuesInt(k, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
									if(!Texto1.equals("")&&!Texto1.equals("0")) {
										driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//textarea[@class='dx-texteditor-input'])[31]")).sendKeys(Texto1);
									}
									String Texto2 =getCellValueSString(k, 3, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
									if(!Texto2.equals("")) {
										driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])/..//input[@class='dx-texteditor-input'])[45]")).sendKeys(Texto2);
									}
								} else if (OpcAlimentacion1.equals("Niega")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[146]")).click();
								} else if (OpcAlimentacion1.equals("No evaluado")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[147]")).click();
								}								
							}
							// Epidemiologicos
							String OpcEpidemiologicos1 = getCellValueSString(l, 1, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");							
							if (OpcEpidemiologicos1.equals("")) {
								System.out.print("No hay datos en Epidemiologicos");
							} else {
								driver.findElement(OpcEpidemiologicos).click();
								Thread.sleep(500);
								// Datos Lactancia artificial
								if (OpcEpidemiologicos1.equals("Refiere")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[148]")).click();				
									String Texto1 =getCellValueSString(l, 2, "AntecedentesMorbidos","Historia Clinica Medicina Fisica");
									if(!Texto1.equals("")&&!Texto1.equals("0")) {
										driver.findElement(By.xpath("((//*[@class='dx-datagrid-rowsview dx-datagrid-nowrap'])/..//input[@class='dx-texteditor-input'])[46]")).sendKeys(Texto1);
									}									
								} else if (OpcEpidemiologicos1.equals("Niega")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[149]")).click();
								} else if (OpcEpidemiologicos1.equals("No evaluado")) {
									driver.findElement(By.xpath("((//*[@class='dx-datagrid-table dx-datagrid-table-fixed'])/..//div[@class='dx-radio-value-container'])[150]")).click();
								}
							}
						}
					}
	
	public void AntecedentesFamiliaresMUD(WebDriver driver, int j) throws InterruptedException, IOException {
			driver.findElement(OpcionAntecedentesFami).click();
			Thread.sleep(500);
			String EstadoOtro = getCellValueSString(j, 1, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
			String EstadoHipertensior = getCellValueSString(j, 7, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
			String EstadoDiabetes = getCellValueSString(j, 13, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
			String EstadoCancer = getCellValueSString(j, 19, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");

			if (EstadoOtro.equals("") && EstadoHipertensior.equals("") && EstadoDiabetes.equals("")
					&& EstadoCancer.equals("")) {
			} else {
				// DATOS OTROS
				if (EstadoOtro.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[136]"))
							.click();
					Thread.sleep(500);
					String Abuelos = getCellValueSString(j, 2, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Padres = getCellValueSString(j, 3, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Primos = getCellValueSString(j, 4, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Hermanos = getCellValueSString(j, 5, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Texto1 = getCellValueSString(j, 6, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					if (Abuelos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[1]")).click();
					}
					if (Padres.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[2]")).click();
					}
					if (Primos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[3]")).click();
					}
					if (Hermanos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[4]")).click();
					}
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[54]")).sendKeys(Texto1);
				} else if (EstadoOtro.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[137]")).click();
				} else if (EstadoOtro.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[138]")).click();
				}
				// DATOS Hipertensi�n arterial
				if (EstadoHipertensior.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[139]")).click();
					Thread.sleep(500);
					String Abuelos = getCellValueSString(j, 8, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Padres = getCellValueSString(j, 9, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Primos = getCellValueSString(j, 10, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Hermanos = getCellValueSString(j, 11, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Texto1 = getCellValueSString(j, 12, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					if (Abuelos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[5]")).click();
					}
					if (Padres.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[6]")).click();
					}
					if (Primos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[7]")).click();
					}
					if (Hermanos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[8]")).click();
					}
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[55]")).sendKeys(Texto1);
				} else if (EstadoHipertensior.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[140]")).click();
				} else if (EstadoHipertensior.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[141]")).click();
				}

				// DATOS Diabetes
				if (EstadoDiabetes.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[142]")).click();
					Thread.sleep(500);
					String Abuelos = getCellValueSString(j, 14, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Padres = getCellValueSString(j, 15, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Primos = getCellValueSString(j, 16, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Hermanos = getCellValueSString(j, 17, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Texto1 = getCellValueSString(j, 18, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					if (Abuelos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[9]")).click();
					}
					if (Padres.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[10]")).click();
					}
					if (Primos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[11]")).click();
					}
					if (Hermanos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[12]")).click();
					}
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[56]")).sendKeys(Texto1);
				} else if (EstadoDiabetes.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[143]")).click();
				} else if (EstadoDiabetes.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[144]")).click();
				}

				// DATOS Cáncer
				if (EstadoCancer.equals("Refiere")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[145]")).click();
					Thread.sleep(500);
					String Abuelos = getCellValueSString(j, 18, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Padres = getCellValueSString(j, 19, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Primos = getCellValueSString(j, 20, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Hermanos = getCellValueSString(j, 21, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					String Texto1 = getCellValueSString(j, 22, "AntecedentesFamiliares","Historia Clinica Medicina de Urgencia");
					if (Abuelos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[13]")).click();
					}
					if (Padres.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[14]")).click();
					}
					if (Primos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[15]")).click();
					}
					if (Hermanos.equals("SI")) {
						driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[16]")).click();
					}
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[57]")).sendKeys(Texto1);
				} else if (EstadoCancer.equals("Niega")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[146]")).click();
				} else if (EstadoCancer.equals("No evaluado")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[147]")).click();
				}
			}
		
	}

	public void AntecedentesFamiliaresPediatria(WebDriver driver, int j) throws InterruptedException, IOException {
		driver.findElement(OpcionAntecedentesFami).click();
		Thread.sleep(500);
		String EstadoOtro = getCellValueSString(j, 1, "AntecedentesFamiliares","Historia Clinica Pediatria");
		String EstadoHipertensior = getCellValueSString(j, 7, "AntecedentesFamiliares","Historia Clinica Pediatria");
		String EstadoDiabetes = getCellValueSString(j, 13, "AntecedentesFamiliares","Historia Clinica Pediatria");
		String EstadoCancer = getCellValueSString(j, 19, "AntecedentesFamiliares","Historia Clinica Pediatria");

		if (EstadoOtro.equals("") && EstadoHipertensior.equals("") && EstadoDiabetes.equals("")
				&& EstadoCancer.equals("")) {
		} else {
			// DATOS OTROS
			if (EstadoOtro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[118]")).click();
				Thread.sleep(500);
				String Abuelos = getCellValueSString(j, 2, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Padres = getCellValueSString(j, 3, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Primos = getCellValueSString(j, 4, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Hermanos = getCellValueSString(j, 5, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Texto1 = getCellValueSString(j, 6, "AntecedentesFamiliares","Historia Clinica Pediatria");
				if (Abuelos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[1]")).click();
				}
				if (Padres.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[2]")).click();
				}
				if (Primos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[3]")).click();
				}
				if (Hermanos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[4]")).click();
				}
				if(!Texto1.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[51]")).sendKeys(Texto1);
				}
			} else if (EstadoOtro.equals("Niega")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[119]")).click();
			} else if (EstadoOtro.equals("No evaluado")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[120]")).click();
			}
			// DATOS Hipertensión arterial
			if (EstadoHipertensior.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[121]")).click();
				Thread.sleep(500);
				String Abuelos = getCellValueSString(j, 8, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Padres = getCellValueSString(j, 9, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Primos = getCellValueSString(j, 10, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Hermanos = getCellValueSString(j, 11, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Texto1 = getCellValueSString(j, 12, "AntecedentesFamiliares","Historia Clinica Pediatria");
				if (Abuelos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[5]")).click();
				}
				if (Padres.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[6]")).click();
				}
				if (Primos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[7]")).click();
				}
				if (Hermanos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[8]")).click();
				}				
				if(!Texto1.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[52]")).sendKeys(Texto1);
				}
			} else if (EstadoHipertensior.equals("Niega")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[122]")).click();
			} else if (EstadoHipertensior.equals("No evaluado")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[123]")).click();
			}

			// DATOS Diabetes
			if (EstadoDiabetes.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[124]")).click();
				Thread.sleep(500);
				String Abuelos = getCellValueSString(j, 14, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Padres = getCellValueSString(j, 15, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Primos = getCellValueSString(j, 16, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Hermanos = getCellValueSString(j, 17, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Texto1 = getCellValueSString(j, 18, "AntecedentesFamiliares","Historia Clinica Pediatria");
				if (Abuelos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[9]")).click();
				}
				if (Padres.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[10]")).click();
				}
				if (Primos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[11]")).click();
				}
				if (Hermanos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[12]")).click();
				}
				if(!Texto1.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[53]")).sendKeys(Texto1);
				}
			} else if (EstadoDiabetes.equals("Niega")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[125]")).click();
			} else if (EstadoDiabetes.equals("No evaluado")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[126]")).click();
			}

			// DATOS Cancer
			if (EstadoCancer.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[127]")).click();
				Thread.sleep(500);
				String Abuelos = getCellValueSString(j, 18, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Padres = getCellValueSString(j, 19, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Primos = getCellValueSString(j, 20, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Hermanos = getCellValueSString(j, 21, "AntecedentesFamiliares","Historia Clinica Pediatria");
				String Texto1 = getCellValueSString(j, 22, "AntecedentesFamiliares","Historia Clinica Pediatria");
				if (Abuelos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[13]")).click();
				}
				if (Padres.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[14]")).click();
				}
				if (Primos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[15]")).click();
				}
				if (Hermanos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[16]")).click();
				}
				if(!Texto1.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[54]")).sendKeys(Texto1);
				}
			} else if (EstadoCancer.equals("Niega")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[128]")).click();
			} else if (EstadoCancer.equals("No evaluado")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[129]")).click();
			}
		}	
}

	public void AntecedentesFamiliaresMFisica(WebDriver driver, int j) throws InterruptedException, IOException {
		driver.findElement(OpcionAntecedentesFami).click();
		Thread.sleep(500);
		String EstadoOtro = getCellValueSString(j, 1, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
		String EstadoHipertensior = getCellValueSString(j, 7, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
		String EstadoDiabetes = getCellValueSString(j, 13, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
		String EstadoCancer = getCellValueSString(j, 19, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");

		if (EstadoOtro.equals("") && EstadoHipertensior.equals("") && EstadoDiabetes.equals("")
				&& EstadoCancer.equals("")) {
		} else {
			// DATOS OTROS
			if (EstadoOtro.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[139]")).click();
				Thread.sleep(500);
				String Abuelos = getCellValueSString(j, 2, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Padres = getCellValueSString(j, 3, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Primos = getCellValueSString(j, 4, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Hermanos = getCellValueSString(j, 5, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Texto1 = getCellValueSString(j, 6, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				if (Abuelos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[1]")).click();
				}
				if (Padres.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[2]")).click();
				}
				if (Primos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[3]")).click();
				}
				if (Hermanos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[4]")).click();
				}
				if(!Texto1.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[55]")).sendKeys(Texto1);
				}
			} else if (EstadoOtro.equals("Niega")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[140]")).click();
			} else if (EstadoOtro.equals("No evaluado")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[141]")).click();
			}
			// DATOS Hipertension arterial
			if (EstadoHipertensior.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[142]")).click();
				Thread.sleep(500);
				String Abuelos = getCellValueSString(j, 8, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Padres = getCellValueSString(j, 9, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Primos = getCellValueSString(j, 10, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Hermanos = getCellValueSString(j, 11, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Texto1 = getCellValueSString(j, 12, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				if (Abuelos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[5]")).click();
				}
				if (Padres.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[6]")).click();
				}
				if (Primos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[7]")).click();
				}
				if (Hermanos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[8]")).click();
				}				
				if(!Texto1.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[56]")).sendKeys(Texto1);
				}
			} else if (EstadoHipertensior.equals("Niega")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[143]")).click();
			} else if (EstadoHipertensior.equals("No evaluado")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[144]")).click();
			}

			// DATOS Diabetes
			if (EstadoDiabetes.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[145]")).click();
				Thread.sleep(500);
				String Abuelos = getCellValueSString(j, 14, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Padres = getCellValueSString(j, 15, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Primos = getCellValueSString(j, 16, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Hermanos = getCellValueSString(j, 17, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Texto1 = getCellValueSString(j, 18, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				if (Abuelos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[9]")).click();
				}
				if (Padres.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[10]")).click();
				}
				if (Primos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[11]")).click();
				}
				if (Hermanos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[12]")).click();
				}
				if(!Texto1.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[57]")).sendKeys(Texto1);
				}
			} else if (EstadoDiabetes.equals("Niega")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[146]")).click();
			} else if (EstadoDiabetes.equals("No evaluado")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[147]")).click();
			}

			// DATOS Cáncer
			if (EstadoCancer.equals("Refiere")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[148]")).click();
				Thread.sleep(500);
				String Abuelos = getCellValueSString(j, 18, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Padres = getCellValueSString(j, 19, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Primos = getCellValueSString(j, 20, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Hermanos = getCellValueSString(j, 21, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				String Texto1 = getCellValueSString(j, 22, "AntecedentesFamiliares","Historia Clinica Medicina Fisica");
				if (Abuelos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[13]")).click();
				}
				if (Padres.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[14]")).click();
				}
				if (Primos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[15]")).click();
				}
				if (Hermanos.equals("SI")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-checkbox-container'])[16]")).click();
				}
				if(!Texto1.equals("")) {
					driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//input[@class='dx-texteditor-input'])[58]")).sendKeys(Texto1);
				}
			} else if (EstadoCancer.equals("Niega")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[149]")).click();
			} else if (EstadoCancer.equals("No evaluado")) {
				driver.findElement(By.xpath("((//*[@class='dx-row dx-data-row dx-column-lines'])/..//div[@class='dx-radio-value-container'])[150]")).click();
			}
		}	
}
	
	public void SignosVitalesMUD(WebDriver driver, int a, String Libro) throws InterruptedException, IOException {
		String ViaTemperatura = getCellValueSString(a, 0, "SignosVitales",Libro);
		String tempeActual = "" + getCellValuessDouble(a, 1, "SignosVitales",Libro);
		String FC = "" + getCellValuesInt(a, 3, "SignosVitales",Libro);
		String FR = "" + getCellValuesInt(a, 4,"SignosVitales",Libro);
		String SO = "" + getCellValuesInt(a, 5,"SignosVitales",Libro);
		String ViaAdmOxigeno = getCellValueSString(a, 2,"SignosVitales",Libro);
		String FOI = "" + getCellValuesInt(a, 6,"SignosVitales",Libro);
		String TAASistolica = "" + getCellValuesInt(a, 7,"SignosVitales",Libro);
		String TAADiastolica = "" + getCellValuesInt(a, 8,"SignosVitales",Libro);
		Thread.sleep(1000);
		String Edad = driver.findElement(DatoEdad).getText().strip();
		String EdadA = Edad.split(" ")[0];
		String EdadM = Edad.split(" ")[3];
		String EdadD = Edad.split(" ")[6];
		double DatoEdadAD = Double.parseDouble(EdadA);
		double DatoEdadMD = Double.parseDouble(EdadM);
		double DatoEdadDD = Double.parseDouble(EdadD);
		driver.findElement(OpcionSignosVitales).click();
		Thread.sleep(1000);
		System.out.println("El libro usado es: " + Libro);
		try {
			System.out.println("Via de temperatura: " + ViaTemperatura);
			driver.findElement(OpcTemp).click();
			Thread.sleep(1000);	
			//driver.findElement(By.xpath("(//*[@class='dx-scrollable-wrapper'])[7]/..//div[contains(text(),'" + ViaTemperatura + "')]")).click();
			driver.findElement(By.xpath("(//*[@class='dx-scrollable-wrapper'])/..//div[contains(text(),'" + ViaTemperatura + "')]")).click();
			driver.findElement(Temperatura).click();
			driver.findElement(Temperatura).sendKeys(tempeActual);
			if (tempeActual.indexOf(",") != -1) {
				tempeActual = tempeActual.replace(",", ".");
			}
			double TempA = Double.parseDouble(tempeActual);
			if (TempA >= 36.2 && TempA <= 38) {
				// lactante inicia a los 42 dias y finaliza a 1 Año
				if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42) || (DatoEdadAD == 1)
						|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
					if (TempA >= 37.5 && TempA <= 37.8) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.1");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// Recien nacido menos de 48 dias
				if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
					if (TempA == 38) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// Niños de 1 Año a 6 Años
				if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 1 && DatoEdadAD < 6)) {
					if (TempA >= 37.5 && TempA <= 37.8) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println(
								"Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}

				// Niños de 6 Años a 13 Años
				if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
					if (TempA >= 37 && TempA <= 37.5) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// Niños de 13 Años a 16 Años
				if ((DatoEdadAD == 13 && DatoEdadMD >= 1) || (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
					if (TempA == 37) {
						System.out
								.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.9");
					} else {
						System.out.println(
								"Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// 16 Años
				if ((DatoEdadAD == 16 && DatoEdadMD >= 1) || (DatoEdadAD == 16 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 16 && DatoEdadAD <= 139)) {
					if (TempA >= 36.2 && TempA <= 37.5) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println(
								"Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
			} else {
				System.out
						.println("Temperatura ingresada " + TempA + ", no corresponde con los parametros establecidos");
			}
		} catch (NumberFormatException e) {
			System.out.println("La Temperatura ingresada  ingresada " + tempeActual + " no es Numerico");
		}

		// validacion Frecuencia Cardiaca
		try {
			driver.findElement(FrecuenciaC).click();
			driver.findElement(FrecuenciaC).sendKeys(FC);
			if (FC.indexOf(",") != -1) {
				FC = FC.replace(",", ".");
			}
			double DatoFc = Double.parseDouble(FC);

			System.out.println(DatoFc);
			if (DatoFc >= 70 && DatoFc <= 140) {
				System.out.println("Si entra");
				// Recien Nacidos 0 dias a 42
				System.out.println("Validacion 1");
				if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
					if (DatoFc >= 120 && DatoFc <= 140) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println(
								"Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.0");
					}
				}
				//// lactante inicia a los 42 dias y finaliza a 1 Año
				if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42) || (DatoEdadAD == 1)
						|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
					if (DatoFc >= 100 && DatoFc <= 130) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out
								.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad");
					}
				}
				// 1 Año a 2 Año
				if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 1 && DatoEdadAD <= 2 && DatoEdadMD == 0)) {
					if (DatoFc >= 100 && DatoFc <= 120) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out
								.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad");
					}
				}
				// 2 Años a 6 Años
				if ((DatoEdadAD == 2 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 1 && DatoEdadAD < 6)) {
					if (DatoFc >= 80 && DatoFc <= 120) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println(
								"Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.");
					}
				}
				// 6 Años y 13 Años
				if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
					if (DatoFc >= 80 && DatoFc <= 100) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println(
								"Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.4");
					}
				}
				// >13 Años y 16 Años
				if ((DatoEdadAD == 13 && DatoEdadMD >= 1) || (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
					if (DatoFc >= 70 && DatoFc <= 80) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println(
								"Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.5");
					}
				}
				// >16 Años
				if (DatoEdadAD > 16) {
					if (DatoFc >= 60 && DatoFc <= 80) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println(
								"Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.");
					}
				}
			} else {
				System.out
						.println("Frecuencia Cardiaca " + DatoFc + ", no corresponde con los parametros establecidos");
			}
		} catch (NumberFormatException e) {
			System.out.println("La Frecuencia Cardiaca ingresada " + FC + " no es Numerico");
		}
		
		// Validacion Frecuancia Respiratoria
					try {
						driver.findElement(FrecuenciaR).click();
						driver.findElement(FrecuenciaR).sendKeys(FR);
						if (FR.indexOf(",") != -1) {
							FR = FR.replace(",", ".");
						}
						double DatoFr = Double.parseDouble(FR);
						if (DatoFr >= 12 && DatoFr <= 45) {
							// Neonato
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
								if (DatoFr >= 40 && DatoFr <= 45) {
									System.out.println(
											"Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							//// lactante inicia a los 42 dias y finaliza a 1 Año
							if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42)
									|| (DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
								if (DatoFr >= 20 && DatoFr <= 30) {
									System.out.println(
											"Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 1 Año a 6 Años
							if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 1 && DatoEdadAD <= 6)) {
								if (DatoFr >= 20 && DatoFr <= 30) {
									System.out.println(
											"Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 6 Años a 13 Años
							if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
								if (DatoFr >= 12 && DatoFr <= 20) {
									System.out.println(
											"Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 13 Años a 16 Años
							if ((DatoEdadAD == 13 && DatoEdadMD >= 1)
									|| (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
								if (DatoFr >= 12 && DatoFr <= 20) {
									System.out.println(
											"Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}

							// Adulto Mayor = >=65 Años
							if (DatoEdadAD > 16) {
								if (DatoFr >= 12 && DatoFr <= 20) {
									System.out.println(
											"Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
						} else {
							System.out.println("Frecuencia Respiratoria " + DatoFr + ", no corresponde con los parametros establecidos");
						}
					} catch (NumberFormatException e) {
						System.out.println("La frecuencia Respiratoria ingresada " + FR + " no es Numerico");
					}
					
					// Validacion Saturacion Oxigeno
					try {
						driver.findElement(SaturacionOxigeno).click();
						driver.findElement(SaturacionOxigeno).sendKeys(SO);

						if (SO.indexOf(",") != -1) {
							SO = SO.replace(",", ".");
						}
						double DatoSo = Double.parseDouble(SO);
						if (DatoSo >= 95 && DatoSo <= 100) {
							System.out.println("Saturacion de Oxigeno en " + DatoSo + ", rango de porcentaje Normal.");
						} else {
							System.out.println("Saturacion de Oxigeno en " + DatoSo + ", rango de porcentaje No Normal.");
						}
					} catch (NumberFormatException e) {
						System.out.println("La Saturacion de Oxigeno ingresada " + SO + " no es Numerico");
					}
				    System.out.println(ViaAdmOxigeno);
					driver.findElement(OpcViaAdmi).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("(//*[@class='dx-scrollable-wrapper'])/..//div[contains(text(),'" + ViaAdmOxigeno + "')]")).click();
					
					//Validacion Fraccion de Oxigeno Inspirado
					try {						
						driver.findElement(FraccionOxIm).click();
						Thread.sleep(2000);
						driver.findElement(FraccionOxIm).sendKeys(FOI);
						if (FOI.indexOf(",") != -1) {
							FOI = FOI.replace(",", ".");
						}
						double DatoFoiD = Double.parseDouble(FOI);
						if (DatoFoiD >= 25 && DatoFoiD <= 40) {
							System.out.println("Fraccion de Oxigeno Inspirado en " + DatoFoiD + ", rango de valor adecuado.");
						} else {
							System.out.println("Fraccion de Oxigeno Inspirado en " + DatoFoiD+ ", rango de valor inadecuado; valor normal >= 25 y <= 40.");
						}
					} catch (NumberFormatException e) {
						System.out.println("La Fraccion de Oxigeno Inspirado ingresada " + SO + " no es Numerico");
					}					
										
					System.out.println("Tensi�n Arterial");
					//Validacion Tension Arterial 
					try {
						driver.findElement(TAASLocator).click();
						driver.findElement(TAASLocator).sendKeys(TAASistolica);
						if (TAASistolica.indexOf(",") != -1) {
							TAASistolica = TAASistolica.replace(",", ".");
						}
						double DatoTAAS = Double.parseDouble(TAASistolica);

						if (DatoTAAS >= 70 && DatoTAAS <= 140) {
							// Neonato
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
								if (DatoTAAS >= 70 && DatoTAAS <= 100) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							//// lactante inicia a los 42 dias y finaliza a 1 Año
							if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
								if (DatoTAAS >= 84 && DatoTAAS <= 106) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 1 Año a 2 Años
							if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 1 && DatoEdadAD <= 2 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
								if (DatoTAAS >= 98 && DatoTAAS <= 106) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 2 Año a 6 Años
							if ((DatoEdadAD == 2 && DatoEdadMD >= 1) || (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 2 && DatoEdadAD <= 6 && DatoEdadMD == 0)) {
								if (DatoTAAS >= 99 && DatoTAAS <= 112) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 6 Años a 13 Años
							if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
								if (DatoTAAS >= 104 && DatoTAAS <= 124) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 13 Años a 16 Años
							if ((DatoEdadAD == 13 && DatoEdadMD >= 1)
									|| (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
								if (DatoTAAS >= 118 && DatoTAAS <= 132) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}

							// Adulto Mayor = >=65 Años
							if (DatoEdadAD > 16) {
								if (DatoTAAS >= 110 && DatoTAAS <= 140) {
									System.out.println("Tensi�n Arterial Acostado(Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial Acostado(Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}

						} else {
							System.out.println("Tensi�n Arterial (Sist�lica) " + TAASistolica+ ", no esta dentro de los parametros.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Tensi�n Arterial (Sist�lica) " + TAASistolica + " no es Numerico");
					}
					// Validacion Tension Arterial 
					try {
						driver.findElement(TAADLocator).click();
						driver.findElement(TAADLocator).sendKeys(TAADiastolica);
						if (TAADiastolica.indexOf(",") != -1) {
							TAADiastolica = TAADiastolica.replace(",", ".");
						}
						double DatoTAAD = Double.parseDouble(TAADiastolica);
						if (DatoTAAD >= 50 && DatoTAAD <= 90) {
							// Neonato
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
								if (DatoTAAD >= 50 && DatoTAAD <= 68) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							//// lactante inicia a los 42 dias y finaliza a 1 Año
							if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
								if (DatoTAAD >= 56 && DatoTAAD <= 70) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 1 Año a 2 Años
							if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 1 && DatoEdadAD <= 2 && DatoEdadMD == 0)) {
								if (DatoTAAD >= 58 && DatoTAAD <= 70) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 2 Año a 6 Años
							if ((DatoEdadAD == 2 && DatoEdadMD >= 1) || (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 2 && DatoEdadAD <= 6 && DatoEdadMD == 0)) {
								if (DatoTAAD >= 64 && DatoTAAD <= 70) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 6 Años a 13 Años
							if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
								if (DatoTAAD >= 64 && DatoTAAD <= 86) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 13 Años a 16 Años
							if ((DatoEdadAD == 13 && DatoEdadMD >= 1)
									|| (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
								if (DatoTAAD >= 70 && DatoTAAD <= 82) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}

							// mayor de 16 Años
							if (DatoEdadAD > 16) {
								if (DatoTAAD >= 70 && DatoTAAD <= 90) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}

						} else {
							System.out.println("Tensi�n Arterial Acostado(Diast�lica) " + DatoTAAD+ ", no esta dentro de los parametros.");
						}

					} catch (NumberFormatException e) {
						System.out.println("Tensi�n Arterial Acostado(Diast�lica) " + TAADiastolica + " no es Numerico");
					}
					new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@class='dx-item dx-box-item']/..//iframe")));
					Thread.sleep(500);
					WebElement element1 = driver.findElement(By.xpath("(//*[@class='container-fluid'])/h4"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
					String EVA =getCellValueSString(a, 9,"SignosVitales","Historia Clinica Medicina de Urgencia");
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[2]")).click();
					Thread.sleep(1000);
					if(EVA.equals("")) {
						System.out.println("No se selecicono una escala de EVA");
					}else if(EVA.equals("Sin Dolor")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[1]")).click();
						Thread.sleep(1000);
						String Observaciones =getCellValueSString(a, 10,"SignosVitales","Historia Clinica Medicina de Urgencia");
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Leve")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[2]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales","Historia Clinica Medicina de Urgencia");
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Moderado")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[3]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales","Historia Clinica Medicina de Urgencia");
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Severo")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[4]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales","Historia Clinica Medicina de Urgencia");
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Muy Severo")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[5]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales","Historia Clinica Medicina de Urgencia");
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("M�ximo Dolor")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[6]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales","Historia Clinica Medicina de Urgencia");
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[10]/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("((//*[@class='dx-scrollview-content'])/..//iframe)[2]")));
					// Campos Medidas Antropometr�a
					String peso =""+getCellValuesInt(a, 11,"SignosVitales","Historia Clinica Medicina de Urgencia");
					String Talla =""+getCellValuesInt(a, 12,"SignosVitales","Historia Clinica Medicina de Urgencia");
					String PA =""+getCellValuesInt(a, 13,"SignosVitales","Historia Clinica Medicina de Urgencia");
					driver.findElement(pesoLocator).click();
					driver.findElement(pesoLocator).sendKeys(peso);
					driver.findElement(TallaLocator).click();
					driver.findElement(TallaLocator).sendKeys(Talla);
					driver.findElement(PerimetroAbdominalLocator).click();
					driver.findElement(PerimetroAbdominalLocator).sendKeys(PA);
					int con = 0;
					try {
						if (peso.indexOf(",") != -1) {
							peso = peso.replace(",", ".");
						}
						double Peso = Double.parseDouble(peso);
						if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD != 0)
								|| (DatoEdadAD <= 4 && DatoEdadMD != 0 && DatoEdadDD != 0)) {
							if (Peso > 0 && Peso < 40) {
								System.out.println("el paciente es un ni�o");
								// 0 dias hasta 30 dias
								if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 30)) {
									if (Peso >= 2.8 && Peso <= 4.4) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 1 mes hasta 3 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 2 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD == 0)) {
									if (Peso >= 3.9 && Peso <= 8.0) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 meses hasta 5 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 4 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD == 0)) {
									if (Peso >= 5.7 && Peso <= 9.3) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 5 meses hasta 8 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 7 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD == 0)) {
									if (Peso >= 6.7 && Peso <= 10.7) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 8 meses hasta 11 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 9 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 10 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD == 0)) {
									if (Peso >= 7.7 && Peso <= 11.7) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 11 meses hasta 2 Años
								if ((DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD >= 1)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (Peso >= 8.4 && Peso <= 15.3) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 2 Años hasta 3 Años y 6 meses
								if ((DatoEdadAD == 2 && DatoEdadMD != 0 && DatoEdadDD != 0)
										|| (DatoEdadAD == 2 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD <= 6 && DatoEdadDD == 0)) {
									if (Peso >= 10.8 && Peso <= 19.7) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.2");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 Años y 6 meses hasta 5 Años
								if ((DatoEdadAD == 3 && DatoEdadMD >= 6 && DatoEdadDD != 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 5 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (Peso >= 13.6 && Peso <= 24.2) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
							} else {
								System.out.println("Valor ingresado de peso no es valido");
							}
						}
					} catch (NumberFormatException e) {
						con = 1;
						System.out.println("El valor ingresado de peso " + peso + ", no es Numerico");

					}

					try {
						if (Talla.indexOf(",") != -1) {
							Talla = Talla.replace(",", ".");
						}
						double talla = Double.parseDouble(Talla);
						if (talla >= 48.0 && talla <= 110.0) {			
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD <= 4 && DatoEdadMD != 0 && DatoEdadDD != 0)) {

								System.out.println("La talla1 ingresada es " + talla);
								// 0 dias hasta 30 dias
								if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 30)) {
									if (talla >= 48.0 && talla <= 49.9) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 1 mes hasta 3 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 2 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD == 0)) {
									if (talla >= 52.8 && talla <= 61.4) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 meses hasta 5 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 4 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD == 0)) {
									if (talla >= 59.4 && talla <= 65.9) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 5 meses hasta 8 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 7 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD == 0)) {
									if (talla >= 63.8 && talla <= 70.6) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 8 meses hasta 11 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 9 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 10 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD == 0)) {
									if (talla >= 68.4 && talla <= 74.5) {
										System.out.println(
												"Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 11 meses hasta 2 Años
								if ((DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD >= 1)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (talla >= 72.2 && talla <= 87.8) {
										System.out.println(
												"Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 2 Años hasta 3 Años y 6 meses
								if ((DatoEdadAD == 2 && DatoEdadMD != 0 && DatoEdadDD != 0)
										|| (DatoEdadAD == 2 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD <= 6 && DatoEdadDD == 0)) {
									System.out.println("si");
									if (talla >= 84.8 && talla <= 99.9) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.1");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 Años y 6 meses hasta 5 Años
								if ((DatoEdadAD == 3 && DatoEdadMD >= 6 && DatoEdadDD != 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 5 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (talla >= 95.9 && talla <= 120) {
										System.out.println(
												"Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
							} 
						}else if (talla >= 144.0 && talla <= 150.0) {
								if (con == 0) {
									double Peso = Double.parseDouble(peso);
									if (talla >= 144.0 && talla <= 150.0) {
										if (Peso >= 38.4 && Peso <= 89.8) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 150.0 && talla <= 156.0) {
										if (Peso >=41.6 && Peso <= 97.1) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 156.0 && talla <= 162.0) {
										if (Peso >=45.0 && Peso <= 104.7) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 162.0 && talla <= 166.0) {
										if (Peso >=48.6 && Peso <= 109.9) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 166.0 && talla <= 172.0) {
										if (Peso >=51.0 && Peso <= 118.0) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 172.0 && talla <= 176.0) {
										if (Peso >=54.7 && Peso <= 123.6) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 176.0 && talla <= 184.0) {
										if (Peso >=57.3 && Peso <= 135.1) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (Peso > 140.0 && Peso <= 594.8) {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}

							} else {
								System.out.println("Valor ingresado de talla no es valido");
							}
						

					} catch (NumberFormatException e) {
						System.out.println("El valor ingresado de talla " + Talla + ", no es Numerico");

					}
	}

	public void SignosVitalesPediatria(WebDriver driver, int a, String Libro) throws InterruptedException, IOException {
		String ViaTemperatura = getCellValueSString(a, 0, "SignosVitales",Libro);
		String tempeActual = "" + getCellValuessDouble(a, 1, "SignosVitales",Libro);
		String FC = "" + getCellValuesInt(a, 3, "SignosVitales",Libro);
		String FR = "" + getCellValuesInt(a, 4,"SignosVitales",Libro);
		String SO = "" + getCellValuesInt(a, 5,"SignosVitales",Libro);
		String ViaAdmOxigeno = getCellValueSString(a, 2,"SignosVitales",Libro);
		String FOI = "" + getCellValuesInt(a, 6,"SignosVitales",Libro);
		String TAASistolica = "" + getCellValuesInt(a, 7,"SignosVitales",Libro);
		String TAADiastolica = "" + getCellValuesInt(a, 8,"SignosVitales",Libro);

		Thread.sleep(1000);
		String Edad = driver.findElement(DatoEdad).getText().strip();
		String EdadA = Edad.split(" ")[0];
		String EdadM = Edad.split(" ")[3];
		String EdadD = Edad.split(" ")[6];
		double DatoEdadAD = Double.parseDouble(EdadA);
		double DatoEdadMD = Double.parseDouble(EdadM);
		double DatoEdadDD = Double.parseDouble(EdadD);
		driver.findElement(OpcionSignosVitales).click();
		Thread.sleep(1000);			
		try {
			System.out.println("V�a de temperatura: " + ViaTemperatura);
			driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//div[@class='dx-button-content'])[1]")).click();
			Thread.sleep(800);	
			driver.findElement(By.xpath("(//*[@class='dx-scrollable-wrapper'])/..//div[contains(text(),'" + ViaTemperatura + "')]")).click();
			driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//input[@class='dx-texteditor-input'])[2]")).click();
			driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//input[@class='dx-texteditor-input'])[2]")).sendKeys(tempeActual);
			if (tempeActual.indexOf(",") != -1) {
				tempeActual = tempeActual.replace(",", ".");
			}
			double TempA = Double.parseDouble(tempeActual);
			if (TempA >= 36.2 && TempA <= 38) {
				//// lactante inicia a los 42 dias y finaliza a 1 Año
				if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42) || (DatoEdadAD == 1)
						|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
					if (TempA >= 37.5 && TempA <= 37.8) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.1");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// Recien nacido menos de 48 dias
				if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
					if (TempA == 38) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// Niños de 1 Año a 6 Años
				if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 1 && DatoEdadAD < 6)) {
					if (TempA >= 37.5 && TempA <= 37.8) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}

				// Niños de 6 Años a 13 Años
				if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
					if (TempA >= 37 && TempA <= 37.5) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// Niños de 13 Años a 16 Años
				if ((DatoEdadAD == 13 && DatoEdadMD >= 1) || (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
					if (TempA == 37) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.9");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// 16 Años
				if ((DatoEdadAD == 16 && DatoEdadMD >= 1) || (DatoEdadAD == 16 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 16 && DatoEdadAD <= 139)) {
					if (TempA >= 36.2 && TempA <= 37.5) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
			} else {
				System.out.println("Temperatura ingresada " + TempA + ", no corresponde con los parametros establecidos");
			}
		} catch (NumberFormatException e) {
			System.out.println("La Temperatura ingresada  ingresada " + tempeActual + " no es Numerico");
		}

		// validacion Frecuencia Cardiaca
		try {
			driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//input[@class='dx-texteditor-input'])[3]")).click();
			driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//input[@class='dx-texteditor-input'])[3]")).sendKeys(FC);
			if (FC.indexOf(",") != -1) {
				FC = FC.replace(",", ".");
			}
			double DatoFc = Double.parseDouble(FC);

			System.out.println(DatoFc);
			if (DatoFc >= 70 && DatoFc <= 140) {
				System.out.println("Si entra");
				// Recien Nacidos 0 dias a 42
				System.out.println("Validacion 1");
				if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
					if (DatoFc >= 120 && DatoFc <= 140) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.0");
					}
				}
				//// lactante inicia a los 42 dias y finaliza a 1 Año
				if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42) || (DatoEdadAD == 1)
						|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
					if (DatoFc >= 100 && DatoFc <= 130) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad");
					}
				}
				// 1 Año a 2 Año
				if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 1 && DatoEdadAD <= 2 && DatoEdadMD == 0)) {
					if (DatoFc >= 100 && DatoFc <= 120) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad");
					}
				}
				// 2 Años a 6 Años
				if ((DatoEdadAD == 2 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 1 && DatoEdadAD < 6)) {
					if (DatoFc >= 80 && DatoFc <= 120) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.");
					}
				}
				// 6 Años y 13 Años
				if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
					if (DatoFc >= 80 && DatoFc <= 100) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.4");
					}
				}
				// >13 Años y 16 Años
				if ((DatoEdadAD == 13 && DatoEdadMD >= 1) || (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
					if (DatoFc >= 70 && DatoFc <= 80) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.5");
					}
				}
				// >16 Años
				if (DatoEdadAD > 16) {
					if (DatoFc >= 60 && DatoFc <= 80) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.");
					}
				}
			} else {
				System.out.println("Frecuencia Cardiaca " + DatoFc + ", no corresponde con los parametros establecidos");
			}
		} catch (NumberFormatException e) {
			System.out.println("La Frecuencia Cardiaca ingresada " + FC + " no es Numerico");
		}
		
		// Validacion Frecuancia Respiratoria
					try {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//input[@class='dx-texteditor-input'])[4]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//input[@class='dx-texteditor-input'])[4]")).sendKeys(FR);
						if (FR.indexOf(",") != -1) {
							FR = FR.replace(",", ".");
						}
						double DatoFr = Double.parseDouble(FR);
						if (DatoFr >= 12 && DatoFr <= 45) {
							// Neonato
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
								if (DatoFr >= 40 && DatoFr <= 45) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							//// lactante inicia a los 42 dias y finaliza a 1 Año
							if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42)
									|| (DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
								if (DatoFr >= 20 && DatoFr <= 30) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 1 Año a 6 Años
							if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 1 && DatoEdadAD <= 6)) {
								if (DatoFr >= 20 && DatoFr <= 30) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 6 Años a 13 Años
							if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
								if (DatoFr >= 12 && DatoFr <= 20) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 13 Años a 16 Años
							if ((DatoEdadAD == 13 && DatoEdadMD >= 1)
									|| (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
								if (DatoFr >= 12 && DatoFr <= 20) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}

							// Adulto Mayor = >=65 Años
							if (DatoEdadAD > 16) {
								if (DatoFr >= 12 && DatoFr <= 20) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
						} else {
							System.out.println("Frecuencia Respiratoria " + DatoFr + ", no corresponde con los parametros establecidos");
						}
					} catch (NumberFormatException e) {
						System.out.println("La frecuencia Respiratoria ingresada " + FR + " no es Numerico");
					}
					
					// Validacion Saturacion Oxigeno
					try {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//input[@class='dx-texteditor-input'])[5]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//input[@class='dx-texteditor-input'])[5]")).sendKeys(SO);

						if (SO.indexOf(",") != -1) {
							SO = SO.replace(",", ".");
						}
						double DatoSo = Double.parseDouble(SO);
						if (DatoSo >= 95 && DatoSo <= 100) {
							System.out.println("Saturacion de Oxigeno en " + DatoSo + ", rango de porcentaje Normal.");
						} else {
							System.out.println("Saturacion de Oxigeno en " + DatoSo + ", rango de porcentaje No Normal.");
						}
					} catch (NumberFormatException e) {
						System.out.println("La Saturacion de Oxigeno ingresada " + SO + " no es Numerico");
					}
				    System.out.println(ViaAdmOxigeno);
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//div[@class='dx-button-content'])[2]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("(//*[@class='dx-scrollable-wrapper'])/..//div[contains(text(),'" + ViaAdmOxigeno + "')]")).click();
					
					//Validacion Fraccion de Oxigeno Inspirado
					try {						
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//input[@class='dx-texteditor-input'])[7]")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//input[@class='dx-texteditor-input'])[7]")).sendKeys(FOI);
						if (FOI.indexOf(",") != -1) {
							FOI = FOI.replace(",", ".");
						}
						double DatoFoiD = Double.parseDouble(FOI);
						if (DatoFoiD >= 25 && DatoFoiD <= 40) {
							System.out.println("Fraccion de Oxigeno Inspirado en " + DatoFoiD + ", rango de valor adecuado.");
						} else {
							System.out.println("Fraccion de Oxigeno Inspirado en " + DatoFoiD+ ", rango de valor inadecuado; valor normal >= 25 y <= 40.");
						}
					} catch (NumberFormatException e) {
						System.out.println("La Fraccion de Oxigeno Inspirado ingresada " + SO + " no es Numerico");
					}					
										
					System.out.println("Tensi�n Arterial");
					//Validacion Tension Arterial 
					try {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[5]/..//input[@class='dx-texteditor-input'])[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[5]/..//input[@class='dx-texteditor-input'])[1]")).sendKeys(TAASistolica);
						if (TAASistolica.indexOf(",") != -1) {
							TAASistolica = TAASistolica.replace(",", ".");
						}
						double DatoTAAS = Double.parseDouble(TAASistolica);

						if (DatoTAAS >= 70 && DatoTAAS <= 140) {
							// Neonato
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
								if (DatoTAAS >= 70 && DatoTAAS <= 100) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							//// lactante inicia a los 42 dias y finaliza a 1 Año
							if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
								if (DatoTAAS >= 84 && DatoTAAS <= 106) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 1 Año a 2 Años
							if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 1 && DatoEdadAD <= 2 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
								if (DatoTAAS >= 98 && DatoTAAS <= 106) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 2 Año a 6 Años
							if ((DatoEdadAD == 2 && DatoEdadMD >= 1) || (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 2 && DatoEdadAD <= 6 && DatoEdadMD == 0)) {
								if (DatoTAAS >= 99 && DatoTAAS <= 112) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 6 Años a 13 Años
							if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
								if (DatoTAAS >= 104 && DatoTAAS <= 124) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 13 Años a 16 Años
							if ((DatoEdadAD == 13 && DatoEdadMD >= 1)
									|| (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
								if (DatoTAAS >= 118 && DatoTAAS <= 132) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}

							// Adulto Mayor = >=65 Años
							if (DatoEdadAD > 16) {
								if (DatoTAAS >= 110 && DatoTAAS <= 140) {
									System.out.println("Tensi�n Arterial Acostado(Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial Acostado(Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}

						} else {
							System.out.println("Tensi�n Arterial (Sist�lica) " + TAASistolica+ ", no esta dentro de los parametros.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Tensi�n Arterial (Sist�lica) " + TAASistolica + " no es Numerico");
					}
					// Validacion Tension Arterial 
					try {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[5]/..//input[@class='dx-texteditor-input'])[2]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[5]/..//input[@class='dx-texteditor-input'])[2]")).sendKeys(TAADiastolica);
						if (TAADiastolica.indexOf(",") != -1) {
							TAADiastolica = TAADiastolica.replace(",", ".");
						}
						double DatoTAAD = Double.parseDouble(TAADiastolica);
						if (DatoTAAD >= 50 && DatoTAAD <= 90) {
							// Neonato
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
								if (DatoTAAD >= 50 && DatoTAAD <= 68) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							//// lactante inicia a los 42 dias y finaliza a 1 Año
							if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
								if (DatoTAAD >= 56 && DatoTAAD <= 70) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 1 Año a 2 Años
							if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 1 && DatoEdadAD <= 2 && DatoEdadMD == 0)) {
								if (DatoTAAD >= 58 && DatoTAAD <= 70) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 2 Año a 6 Años
							if ((DatoEdadAD == 2 && DatoEdadMD >= 1) || (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 2 && DatoEdadAD <= 6 && DatoEdadMD == 0)) {
								if (DatoTAAD >= 64 && DatoTAAD <= 70) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 6 Años a 13 Años
							if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
								if (DatoTAAD >= 64 && DatoTAAD <= 86) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 13 Años a 16 Años
							if ((DatoEdadAD == 13 && DatoEdadMD >= 1)
									|| (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
								if (DatoTAAD >= 70 && DatoTAAD <= 82) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}

							// mayor de 16 Años
							if (DatoEdadAD > 16) {
								if (DatoTAAD >= 70 && DatoTAAD <= 90) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}

						} else {
							System.out.println("Tensi�n Arterial Acostado(Diast�lica) " + DatoTAAD+ ", no esta dentro de los parametros.");
						}

					} catch (NumberFormatException e) {
						System.out.println("Tensi�n Arterial Acostado(Diast�lica) " + TAADiastolica + " no es Numerico");
					}
					new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@class='dx-item dx-box-item']/..//iframe")));
					Thread.sleep(500);
					WebElement element1 = driver.findElement(By.xpath("(//*[@class='container-fluid'])/h4"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
					String EVA =getCellValueSString(a, 9,"SignosVitales",Libro);
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[2]")).click();
					Thread.sleep(1000);
					if(EVA.equals("")) {
						System.out.println("No se selecicono una escala de EVA");
					}else if(EVA.equals("Sin Dolor")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[1]")).click();
						Thread.sleep(1000);
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Leve")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[2]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Moderado")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[3]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Severo")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[4]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Muy Severo")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[5]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("M�ximo Dolor")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[6]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("((//*[@class='dx-scrollview-content'])/..//iframe)[2]")));
					// Campos Medidas Antropometr�a
					String peso =""+getCellValuesInt(a, 11,"SignosVitales",Libro);
					String Talla =""+getCellValuesInt(a, 12,"SignosVitales",Libro);
					String PA =""+getCellValuesInt(a, 13,"SignosVitales",Libro);
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[8]/..//input[@class='dx-texteditor-input'])[1]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[8]/..//input[@class='dx-texteditor-input'])[1]")).sendKeys(peso);
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[8]/..//input[@class='dx-texteditor-input'])[2]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[8]/..//input[@class='dx-texteditor-input'])[2]")).sendKeys(Talla);
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[8]/..//input[@class='dx-texteditor-input'])[3]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[8]/..//input[@class='dx-texteditor-input'])[3]")).sendKeys(PA);
					int con = 0;
					try {
						if (peso.indexOf(",") != -1) {
							peso = peso.replace(",", ".");
						}
						double Peso = Double.parseDouble(peso);
						if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD != 0)
								|| (DatoEdadAD <= 4 && DatoEdadMD != 0 && DatoEdadDD != 0)) {
							if (Peso > 0 && Peso < 40) {
								System.out.println("el paciente es un ni�o");
								// 0 dias hasta 30 dias
								if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 30)) {
									if (Peso >= 2.8 && Peso <= 4.4) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 1 mes hasta 3 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 2 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD == 0)) {
									if (Peso >= 3.9 && Peso <= 8.0) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 meses hasta 5 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 4 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD == 0)) {
									if (Peso >= 5.7 && Peso <= 9.3) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 5 meses hasta 8 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 7 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD == 0)) {
									if (Peso >= 6.7 && Peso <= 10.7) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 8 meses hasta 11 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 9 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 10 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD == 0)) {
									if (Peso >= 7.7 && Peso <= 11.7) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 11 meses hasta 2 Años
								if ((DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD >= 1)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (Peso >= 8.4 && Peso <= 15.3) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 2 Años hasta 3 Años y 6 meses
								if ((DatoEdadAD == 2 && DatoEdadMD != 0 && DatoEdadDD != 0)
										|| (DatoEdadAD == 2 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD <= 6 && DatoEdadDD == 0)) {
									if (Peso >= 10.8 && Peso <= 19.7) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.2");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 Años y 6 meses hasta 5 Años
								if ((DatoEdadAD == 3 && DatoEdadMD >= 6 && DatoEdadDD != 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 5 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (Peso >= 13.6 && Peso <= 24.2) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
							} else {
								System.out.println("Valor ingresado de peso no es valido");
							}
						}
					} catch (NumberFormatException e) {
						con = 1;
						System.out.println("El valor ingresado de peso " + peso + ", no es Numerico");

					}

					try {
						if (Talla.indexOf(",") != -1) {
							Talla = Talla.replace(",", ".");
						}
						double talla = Double.parseDouble(Talla);
						if (talla >= 48.0 && talla <= 110.0) {			
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD <= 4 && DatoEdadMD != 0 && DatoEdadDD != 0)) {

								System.out.println("La talla1 ingresada es " + talla);
								// 0 dias hasta 30 dias
								if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 30)) {
									if (talla >= 48.0 && talla <= 49.9) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 1 mes hasta 3 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 2 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD == 0)) {
									if (talla >= 52.8 && talla <= 61.4) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 meses hasta 5 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 4 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD == 0)) {
									if (talla >= 59.4 && talla <= 65.9) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 5 meses hasta 8 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 7 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD == 0)) {
									if (talla >= 63.8 && talla <= 70.6) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 8 meses hasta 11 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 9 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 10 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD == 0)) {
									if (talla >= 68.4 && talla <= 74.5) {
										System.out.println(
												"Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 11 meses hasta 2 Años
								if ((DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD >= 1)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (talla >= 72.2 && talla <= 87.8) {
										System.out.println(
												"Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 2 Años hasta 3 Años y 6 meses
								if ((DatoEdadAD == 2 && DatoEdadMD != 0 && DatoEdadDD != 0)
										|| (DatoEdadAD == 2 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD <= 6 && DatoEdadDD == 0)) {
									System.out.println("si");
									if (talla >= 84.8 && talla <= 99.9) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.1");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 Años y 6 meses hasta 5 Años
								if ((DatoEdadAD == 3 && DatoEdadMD >= 6 && DatoEdadDD != 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 5 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (talla >= 95.9 && talla <= 120) {
										System.out.println(
												"Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
							} 
						}else if (talla >= 144.0 && talla <= 150.0) {
								if (con == 0) {
									double Peso = Double.parseDouble(peso);
									if (talla >= 144.0 && talla <= 150.0) {
										if (Peso >= 38.4 && Peso <= 89.8) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 150.0 && talla <= 156.0) {
										if (Peso >=41.6 && Peso <= 97.1) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 156.0 && talla <= 162.0) {
										if (Peso >=45.0 && Peso <= 104.7) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 162.0 && talla <= 166.0) {
										if (Peso >=48.6 && Peso <= 109.9) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 166.0 && talla <= 172.0) {
										if (Peso >=51.0 && Peso <= 118.0) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 172.0 && talla <= 176.0) {
										if (Peso >=54.7 && Peso <= 123.6) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 176.0 && talla <= 184.0) {
										if (Peso >=57.3 && Peso <= 135.1) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (Peso > 140.0 && Peso <= 594.8) {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}

							} else {
								System.out.println("Valor ingresado de talla no es valido");
							}
						

					} catch (NumberFormatException e) {
						System.out.println("El valor ingresado de talla " + Talla + ", no es Numerico");

					}
	}
	
	public void SignosVitalesMFisica(WebDriver driver, int a, String Libro) throws InterruptedException, IOException {
		String ViaTemperatura = getCellValueSString(a, 0, "SignosVitales",Libro);
		String tempeActual = "" + getCellValuessDouble(a, 1, "SignosVitales",Libro);
		String FC = "" + getCellValuesInt(a, 3, "SignosVitales",Libro);
		String FR = "" + getCellValuesInt(a, 4,"SignosVitales",Libro);
		String SO = "" + getCellValuesInt(a, 5,"SignosVitales",Libro);
		String ViaAdmOxigeno = getCellValueSString(a, 2,"SignosVitales",Libro);
		String FOI = "" + getCellValuesInt(a, 6,"SignosVitales",Libro);
		String TAASistolica = "" + getCellValuesInt(a, 7,"SignosVitales",Libro);
		String TAADiastolica = "" + getCellValuesInt(a, 8,"SignosVitales",Libro);
	
		Thread.sleep(1000);
		String Edad = driver.findElement(DatoEdad).getText().strip();
		String EdadA = Edad.split(" ")[0];
		String EdadM = Edad.split(" ")[3];
		String EdadD = Edad.split(" ")[6];
		double DatoEdadAD = Double.parseDouble(EdadA);
		double DatoEdadMD = Double.parseDouble(EdadM);
		double DatoEdadDD = Double.parseDouble(EdadD);
		driver.findElement(OpcionSignosVitales).click();
		Thread.sleep(1000);			
		try {
			System.out.println("V�a de temperatura: " + ViaTemperatura);
			driver.findElement(By.xpath("(((//*[@class='dx-widget dx-collection dx-responsivebox-screen-lg dx-responsivebox'])[15]/..//div[@class='dx-button-content']))[1]")).click();
			Thread.sleep(800);	
			driver.findElement(By.xpath("(//*[@class='dx-scrollable-wrapper'])/..//div[contains(text(),'" + ViaTemperatura + "')]")).click();
			driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[15]/..//input[@class='dx-texteditor-input'])[2]")).click();
			driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[15]/..//input[@class='dx-texteditor-input'])[2]")).sendKeys(tempeActual);
			if (tempeActual.indexOf(",") != -1) {
				tempeActual = tempeActual.replace(",", ".");
			}
			double TempA = Double.parseDouble(tempeActual);
			if (TempA >= 36.2 && TempA <= 38) {
				//// lactante inicia a los 42 dias y finaliza a 1 Año
				if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42) || (DatoEdadAD == 1)
						|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
					if (TempA >= 37.5 && TempA <= 37.8) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.1");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// Recien nacido menos de 48 dias
				if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
					if (TempA == 38) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// Niños de 1 Año a 6 Años
				if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 1 && DatoEdadAD < 6)) {
					if (TempA >= 37.5 && TempA <= 37.8) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}

				// Niños de 6 Años a 13 Años
				if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
					if (TempA >= 37 && TempA <= 37.5) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// Niños de 13 Años a 16 Años
				if ((DatoEdadAD == 13 && DatoEdadMD >= 1) || (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
					if (TempA == 37) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.9");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
				// 16 Años
				if ((DatoEdadAD == 16 && DatoEdadMD >= 1) || (DatoEdadAD == 16 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 16 && DatoEdadAD <= 139)) {
					if (TempA >= 36.2 && TempA <= 37.5) {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Temperatura ingresada en " + TempA + ", rango de valor no adecuado a la Edad.");
					}
				}
			} else {
				System.out.println("Temperatura ingresada " + TempA + ", no corresponde con los parametros establecidos");
			}
		} catch (NumberFormatException e) {
			System.out.println("La Temperatura ingresada  ingresada " + tempeActual + " no es Numerico");
		}

		// validacion Frecuencia Cardiaca
		try {
			driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[15]/..//input[@class='dx-texteditor-input'])[3]")).click();
			driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[15]/..//input[@class='dx-texteditor-input'])[3]")).sendKeys(FC);
			if (FC.indexOf(",") != -1) {
				FC = FC.replace(",", ".");
			}
			double DatoFc = Double.parseDouble(FC);

			System.out.println(DatoFc);
			if (DatoFc >= 70 && DatoFc <= 140) {
				System.out.println("Si entra");
				// Recien Nacidos 0 dias a 42
				System.out.println("Validacion 1");
				if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
					if (DatoFc >= 120 && DatoFc <= 140) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.0");
					}
				}
				//// lactante inicia a los 42 dias y finaliza a 1 Año
				if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42) || (DatoEdadAD == 1)
						|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
						|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
					if (DatoFc >= 100 && DatoFc <= 130) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad");
					}
				}
				// 1 Año a 2 Año
				if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 1 && DatoEdadAD <= 2 && DatoEdadMD == 0)) {
					if (DatoFc >= 100 && DatoFc <= 120) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad");
					}
				}
				// 2 Años a 6 Años
				if ((DatoEdadAD == 2 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 1 && DatoEdadAD < 6)) {
					if (DatoFc >= 80 && DatoFc <= 120) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.");
					}
				}
				// 6 Años y 13 Años
				if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
					if (DatoFc >= 80 && DatoFc <= 100) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.4");
					}
				}
				// >13 Años y 16 Años
				if ((DatoEdadAD == 13 && DatoEdadMD >= 1) || (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
						|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
					if (DatoFc >= 70 && DatoFc <= 80) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.5");
					}
				}
				// >16 Años
				if (DatoEdadAD > 16) {
					if (DatoFc >= 60 && DatoFc <= 80) {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor adecuado por Edad.");
					} else {
						System.out.println("Frecuencia Cardiaca en " + DatoFc + ", rango de valor no adecuado a la Edad.");
					}
				}
			} else {
				System.out.println("Frecuencia Cardiaca " + DatoFc + ", no corresponde con los parametros establecidos");
			}
		} catch (NumberFormatException e) {
			System.out.println("La Frecuencia Cardiaca ingresada " + FC + " no es Numerico");
		}
		
		// Validacion Frecuancia Respiratoria
					try {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[15]/..//input[@class='dx-texteditor-input'])[4]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[15]/..//input[@class='dx-texteditor-input'])[4]")).sendKeys(FR);
						if (FR.indexOf(",") != -1) {
							FR = FR.replace(",", ".");
						}
						double DatoFr = Double.parseDouble(FR);
						if (DatoFr >= 12 && DatoFr <= 45) {
							// Neonato
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
								if (DatoFr >= 40 && DatoFr <= 45) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							//// lactante inicia a los 42 dias y finaliza a 1 Año
							if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42)
									|| (DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
								if (DatoFr >= 20 && DatoFr <= 30) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 1 Año a 6 Años
							if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 1 && DatoEdadAD <= 6)) {
								if (DatoFr >= 20 && DatoFr <= 30) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 6 Años a 13 Años
							if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
								if (DatoFr >= 12 && DatoFr <= 20) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 13 Años a 16 Años
							if ((DatoEdadAD == 13 && DatoEdadMD >= 1)
									|| (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
								if (DatoFr >= 12 && DatoFr <= 20) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}

							// Adulto Mayor = >=65 Años
							if (DatoEdadAD > 16) {
								if (DatoFr >= 12 && DatoFr <= 20) {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Frecuencia Respiratoria en " + DatoFr + ", rango de valor no adecuado a la Edad.");
								}
							}
						} else {
							System.out.println("Frecuencia Respiratoria " + DatoFr + ", no corresponde con los parametros establecidos");
						}
					} catch (NumberFormatException e) {
						System.out.println("La frecuencia Respiratoria ingresada " + FR + " no es Numerico");
					}
					
					// Validacion Saturacion Oxigeno
					try {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[15]/..//input[@class='dx-texteditor-input'])[5]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[15]/..//input[@class='dx-texteditor-input'])[5]")).sendKeys(SO);

						if (SO.indexOf(",") != -1) {
							SO = SO.replace(",", ".");
						}
						double DatoSo = Double.parseDouble(SO);
						if (DatoSo >= 95 && DatoSo <= 100) {
							System.out.println("Saturacion de Oxigeno en " + DatoSo + ", rango de porcentaje Normal.");
						} else {
							System.out.println("Saturacion de Oxigeno en " + DatoSo + ", rango de porcentaje No Normal.");
						}
					} catch (NumberFormatException e) {
						System.out.println("La Saturacion de Oxigeno ingresada " + SO + " no es Numerico");
					}
				    System.out.println(ViaAdmOxigeno);
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[15]/..//div[@class='dx-button-content'])[2]")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("(//*[@class='dx-scrollable-wrapper'])/..//div[contains(text(),'" + ViaAdmOxigeno + "')]")).click();
					
					//Validacion Fraccion de Oxigeno Inspirado
					try {						
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[15]/..//input[@class='dx-texteditor-input'])[7]")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[15]/..//input[@class='dx-texteditor-input'])[7]")).sendKeys(FOI);
						if (FOI.indexOf(",") != -1) {
							FOI = FOI.replace(",", ".");
						}
						double DatoFoiD = Double.parseDouble(FOI);
						if (DatoFoiD >= 25 && DatoFoiD <= 40) {
							System.out.println("Fraccion de Oxigeno Inspirado en " + DatoFoiD + ", rango de valor adecuado.");
						} else {
							System.out.println("Fraccion de Oxigeno Inspirado en " + DatoFoiD+ ", rango de valor inadecuado; valor normal >= 25 y <= 40.");
						}
					} catch (NumberFormatException e) {
						System.out.println("La Fraccion de Oxigeno Inspirado ingresada " + SO + " no es Numerico");
					}					
										
					System.out.println("Tensi�n Arterial");
					//Validacion Tension Arterial 
					try {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[17]/..//input[@class='dx-texteditor-input'])[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[17]/..//input[@class='dx-texteditor-input'])[1]")).sendKeys(TAASistolica);
						if (TAASistolica.indexOf(",") != -1) {
							TAASistolica = TAASistolica.replace(",", ".");
						}
						double DatoTAAS = Double.parseDouble(TAASistolica);

						if (DatoTAAS >= 70 && DatoTAAS <= 140) {
							// Neonato
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
								if (DatoTAAS >= 70 && DatoTAAS <= 100) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							//// lactante inicia a los 42 dias y finaliza a 1 Año
							if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
								if (DatoTAAS >= 84 && DatoTAAS <= 106) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 1 Año a 2 Años
							if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 1 && DatoEdadAD <= 2 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
								if (DatoTAAS >= 98 && DatoTAAS <= 106) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 2 Año a 6 Años
							if ((DatoEdadAD == 2 && DatoEdadMD >= 1) || (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 2 && DatoEdadAD <= 6 && DatoEdadMD == 0)) {
								if (DatoTAAS >= 99 && DatoTAAS <= 112) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 6 Años a 13 Años
							if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
								if (DatoTAAS >= 104 && DatoTAAS <= 124) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 13 Años a 16 Años
							if ((DatoEdadAD == 13 && DatoEdadMD >= 1)
									|| (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
								if (DatoTAAS >= 118 && DatoTAAS <= 132) {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}

							// Adulto Mayor = >=65 Años
							if (DatoEdadAD > 16) {
								if (DatoTAAS >= 110 && DatoTAAS <= 140) {
									System.out.println("Tensi�n Arterial Acostado(Sist�lica) en " + DatoTAAS+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial Acostado(Sist�lica) en " + DatoTAAS+ ", rango de valor no adecuado a la Edad.");
								}
							}

						} else {
							System.out.println("Tensi�n Arterial (Sist�lica) " + TAASistolica+ ", no esta dentro de los parametros.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Tensi�n Arterial (Sist�lica) " + TAASistolica + " no es Numerico");
					}
					// Validacion Tension Arterial 
					try {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[17]/..//input[@class='dx-texteditor-input'])[2]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[17]/..//input[@class='dx-texteditor-input'])[2]")).sendKeys(TAADiastolica);
						if (TAADiastolica.indexOf(",") != -1) {
							TAADiastolica = TAADiastolica.replace(",", ".");
						}
						double DatoTAAD = Double.parseDouble(TAADiastolica);
						if (DatoTAAD >= 50 && DatoTAAD <= 90) {
							// Neonato
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD <= 12)) {
								if (DatoTAAD >= 50 && DatoTAAD <= 68) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							//// lactante inicia a los 42 dias y finaliza a 1 Año
							if ((DatoEdadAD == 1) || (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD >= 42)
									|| (DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 365)
									|| (DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 12)) {
								if (DatoTAAD >= 56 && DatoTAAD <= 70) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 1 Año a 2 Años
							if ((DatoEdadAD == 1 && DatoEdadMD >= 1) || (DatoEdadAD == 1 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 1 && DatoEdadAD <= 2 && DatoEdadMD == 0)) {
								if (DatoTAAD >= 58 && DatoTAAD <= 70) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 2 Año a 6 Años
							if ((DatoEdadAD == 2 && DatoEdadMD >= 1) || (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 2 && DatoEdadAD <= 6 && DatoEdadMD == 0)) {
								if (DatoTAAD >= 64 && DatoTAAD <= 70) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 6 Años a 13 Años
							if ((DatoEdadAD == 6 && DatoEdadMD >= 1) || (DatoEdadAD == 6 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 6 && DatoEdadAD <= 13)) {
								if (DatoTAAD >= 64 && DatoTAAD <= 86) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}
							// Niños de 13 Años a 16 Años
							if ((DatoEdadAD == 13 && DatoEdadMD >= 1)
									|| (DatoEdadAD == 13 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD >= 13 && DatoEdadAD <= 16)) {
								if (DatoTAAD >= 70 && DatoTAAD <= 82) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}

							// mayor de 16 Años
							if (DatoEdadAD > 16) {
								if (DatoTAAD >= 70 && DatoTAAD <= 90) {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor adecuado por Edad.");
								} else {
									System.out.println("Tensi�n Arterial (Diast�lica) en " + DatoTAAD+ ", rango de valor no adecuado a la Edad.");
								}
							}

						} else {
							System.out.println("Tensi�n Arterial Acostado(Diast�lica) " + DatoTAAD+ ", no esta dentro de los parametros.");
						}

					} catch (NumberFormatException e) {
						System.out.println("Tensi�n Arterial Acostado(Diast�lica) " + TAADiastolica + " no es Numerico");
					}
					new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@class='dx-item dx-box-item']/..//iframe")));
					Thread.sleep(500);
					WebElement element1 = driver.findElement(By.xpath("(//*[@class='container-fluid'])/h4"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
					String EVA =getCellValueSString(a, 9,"SignosVitales",Libro);
					Thread.sleep(1000);
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[2]")).click();
					Thread.sleep(1000);
					if(EVA.equals("")) {
						System.out.println("No se selecicono una escala de EVA");
					}else if(EVA.equals("Sin Dolor")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[1]")).click();
						Thread.sleep(1000);
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Leve")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[2]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Moderado")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[3]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Severo")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[4]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("Dolor Muy Severo")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[5]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}else if(EVA.equals("M�ximo Dolor")) {
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[4]/..//img)[6]")).click();
						String Observaciones =getCellValueSString(a, 10,"SignosVitales",Libro);
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).click();
						driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-texteditor-input-container']/textarea)[1]")).sendKeys(Observaciones);
					}
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("((//*[@class='dx-scrollview-content'])/..//iframe)[2]")));
					// Campos Medidas Antropometr�a
					String peso =""+getCellValuesInt(a, 11,"SignosVitales",Libro);
					String Talla =""+getCellValuesInt(a, 12,"SignosVitales",Libro);
					String PA =""+getCellValuesInt(a, 13,"SignosVitales",Libro);
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[20]/..//input[@class='dx-texteditor-input'])[1]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[20]/..//input[@class='dx-texteditor-input'])[1]")).sendKeys(peso);
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[20]/..//input[@class='dx-texteditor-input'])[2]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[20]/..//input[@class='dx-texteditor-input'])[2]")).sendKeys(Talla);
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[20]/..//input[@class='dx-texteditor-input'])[3]")).click();
					driver.findElement(By.xpath("((//*[@class='dx-layout-manager dx-widget'])[20]/..//input[@class='dx-texteditor-input'])[3]")).sendKeys(PA);
					int con = 0;
					try {
						if (peso.indexOf(",") != -1) {
							peso = peso.replace(",", ".");
						}
						double Peso = Double.parseDouble(peso);
						if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD != 0)
								|| (DatoEdadAD <= 4 && DatoEdadMD != 0 && DatoEdadDD != 0)) {
							if (Peso > 0 && Peso < 40) {
								System.out.println("el paciente es un ni�o");
								// 0 dias hasta 30 dias
								if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 30)) {
									if (Peso >= 2.8 && Peso <= 4.4) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 1 mes hasta 3 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 2 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD == 0)) {
									if (Peso >= 3.9 && Peso <= 8.0) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 meses hasta 5 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 4 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD == 0)) {
									if (Peso >= 5.7 && Peso <= 9.3) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 5 meses hasta 8 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 7 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD == 0)) {
									if (Peso >= 6.7 && Peso <= 10.7) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 8 meses hasta 11 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 9 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 10 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD == 0)) {
									if (Peso >= 7.7 && Peso <= 11.7) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 11 meses hasta 2 Años
								if ((DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD >= 1)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (Peso >= 8.4 && Peso <= 15.3) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 2 Años hasta 3 Años y 6 meses
								if ((DatoEdadAD == 2 && DatoEdadMD != 0 && DatoEdadDD != 0)
										|| (DatoEdadAD == 2 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD <= 6 && DatoEdadDD == 0)) {
									if (Peso >= 10.8 && Peso <= 19.7) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.2");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 Años y 6 meses hasta 5 Años
								if ((DatoEdadAD == 3 && DatoEdadMD >= 6 && DatoEdadDD != 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 5 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (Peso >= 13.6 && Peso <= 24.2) {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor adecuado por Edad.");
									} else {
										System.out.println("Peso ingresado  en " + Peso + ", rango de valor no adecuado a la Edad.");
									}
								}
							} else {
								System.out.println("Valor ingresado de peso no es valido");
							}
						}
					} catch (NumberFormatException e) {
						con = 1;
						System.out.println("El valor ingresado de peso " + peso + ", no es Numerico");

					}

					try {
						if (Talla.indexOf(",") != -1) {
							Talla = Talla.replace(",", ".");
						}
						double talla = Double.parseDouble(Talla);
						if (talla >= 48.0 && talla <= 110.0) {			
							if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD != 0)
									|| (DatoEdadAD <= 4 && DatoEdadMD != 0 && DatoEdadDD != 0)) {

								System.out.println("La talla1 ingresada es " + talla);
								// 0 dias hasta 30 dias
								if ((DatoEdadAD == 0 && DatoEdadMD == 0 && DatoEdadDD <= 30)) {
									if (talla >= 48.0 && talla <= 49.9) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 1 mes hasta 3 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 1 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 2 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD == 0)) {
									if (talla >= 52.8 && talla <= 61.4) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 meses hasta 5 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 3 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 4 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD == 0)) {
									if (talla >= 59.4 && talla <= 65.9) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 5 meses hasta 8 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 5 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 7 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD == 0)) {
									if (talla >= 63.8 && talla <= 70.6) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 8 meses hasta 11 meses
								if ((DatoEdadAD == 0 && DatoEdadMD == 8 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 9 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 10 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD == 0)) {
									if (talla >= 68.4 && talla <= 74.5) {
										System.out.println(
												"Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 11 meses hasta 2 Años
								if ((DatoEdadAD == 0 && DatoEdadMD == 11 && DatoEdadDD >= 1)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 1 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 2 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (talla >= 72.2 && talla <= 87.8) {
										System.out.println(
												"Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 2 Años hasta 3 Años y 6 meses
								if ((DatoEdadAD == 2 && DatoEdadMD != 0 && DatoEdadDD != 0)
										|| (DatoEdadAD == 2 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 3 && DatoEdadMD <= 6 && DatoEdadDD == 0)) {
									System.out.println("si");
									if (talla >= 84.8 && talla <= 99.9) {
										System.out.println("Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.1");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
								// 3 Años y 6 meses hasta 5 Años
								if ((DatoEdadAD == 3 && DatoEdadMD >= 6 && DatoEdadDD != 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 0 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 4 && DatoEdadMD >= 6 && DatoEdadDD >= 0)
										|| (DatoEdadAD == 5 && DatoEdadMD == 0 && DatoEdadDD == 0)) {
									if (talla >= 95.9 && talla <= 120) {
										System.out.println(
												"Talla  ingresada  en " + talla + ", rango de valor adecuado a la Edad.");
									} else {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
							} 
						}else if (talla >= 144.0 && talla <= 150.0) {
								if (con == 0) {
									double Peso = Double.parseDouble(peso);
									if (talla >= 144.0 && talla <= 150.0) {
										if (Peso >= 38.4 && Peso <= 89.8) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 150.0 && talla <= 156.0) {
										if (Peso >=41.6 && Peso <= 97.1) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 156.0 && talla <= 162.0) {
										if (Peso >=45.0 && Peso <= 104.7) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 162.0 && talla <= 166.0) {
										if (Peso >=48.6 && Peso <= 109.9) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 166.0 && talla <= 172.0) {
										if (Peso >=51.0 && Peso <= 118.0) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 172.0 && talla <= 176.0) {
										if (Peso >=54.7 && Peso <= 123.6) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (talla > 176.0 && talla <= 184.0) {
										if (Peso >=57.3 && Peso <= 135.1) {
											System.out.println("Talla y el Peso ingresado  en T(" + talla + ") P(" + Peso+ "), rango de valor adecuado a la Edad.");
										} else {
											System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
										}
									}
									if (Peso > 140.0 && Peso <= 594.8) {
										System.out.println("talla ingresado  en " + talla + ", rango de valor no adecuado a la Edad.");
									}
								}
							} else {
								System.out.println("Valor ingresado de talla no es valido");
							}
					} catch (NumberFormatException e) {
						System.out.println("El valor ingresado de talla " + Talla + ", no es Numerico");
					}
	}
	
	public void ExamenFisicoMUD(WebDriver driver, int a, int b, int c, int d, int e, int f,int g,int h) throws IOException, InterruptedException {
		String Sexo=driver.findElement(SexoPaciente).getText().strip();
		driver.findElement(OpcionExamenFisico).click();
		Thread.sleep(1000);
		// Inspecci�n General		
		String Opc1 = getCellValueSString(a, 1, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		String Opc2 = getCellValueSString(a, 2, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		String Opc3 = getCellValueSString(a, 3, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String Opc4 = getCellValueSString(a, 4, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		String Opc5 = getCellValueSString(a, 5, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		String Opc6 = getCellValueSString(a, 6, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		
		if(Opc1.equals("")&&Opc2.equals("")&&Opc3.equals("")&&Opc4.equals("")&&Opc5.equals("")&&Opc6.equals("")) {
			System.out.println("No se selecciono alguna opcion de Inspeccion General");
		}else {
			if(Opc1.equals("Alerta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[1]")).click();
			}else if(Opc1.equals("Somnoliento")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[2]")).click();
			}else if(Opc1.equals("Estuporoso")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[3]")).click();
			}else if(Opc1.equals("Comatoso")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[4]")).click();
			}
			if(Opc2.equals("Ausente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[5]")).click();
			}else if(Opc2.equals("Leve")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[6]")).click();
			}else if(Opc2.equals("Moderada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[7]")).click();
			}else if(Opc2.equals("Severa")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[8]")).click();
			}
			if(Opc3.equals("Colaborador")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[9]")).click();
			}else if(Opc3.equals("Medianamente Colaborador")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[10]")).click();
			}else if(Opc3.equals("Algo colaborador")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[11]")).click();
			}else if(Opc3.equals("No Colabora con  EF")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[12]")).click();
			}
			if(Opc4.equals("Sin restric�on")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[13]")).click();
			}else if(Opc4.equals("Restricc�on Leve")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[14]")).click();
			}else if(Opc4.equals("Restricc�on Moderada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[15]")).click();
			}else if(Opc4.equals("Postrado")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[16]")).click();
			}
			if(Opc5.equals("Eutr�fico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[17]")).click();
			}else if(Opc5.equals("Obeso")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[18]")).click();
			}else if(Opc5.equals("Anor�xico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[19]")).click();
			}else if(Opc5.equals("Caqu�tico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[20]")).click();
			}
			if(!Opc6.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[1]")).sendKeys(Opc6);
			}
			driver.findElement(OpcionInspeccionGeneral).click();
		}
		
        //Campos Cabeza
		String OpcCabeza1 = getCellValueSString(a, 7, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		String OpcCabeza2 = getCellValueSString(a, 8, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		String OpcCabeza3 = getCellValueSString(a, 9, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcCabeza4 = getCellValueSString(a, 10, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		String OpcCabeza5 = getCellValueSString(a, 11, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		if(OpcCabeza1.equals("")&&OpcCabeza2.equals("")&&OpcCabeza3.equals("")&&OpcCabeza4.equals("")&&OpcCabeza5.equals("")) {
			System.out.println("No se selecciono alguna opcion de Cabeza");
		}else {
			driver.findElement(OpcionCabeza).click();
			if(OpcCabeza1.equals("Normocr�neo")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[21]")).click();
			}else if(OpcCabeza1.equals("Microcef�lico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[22]")).click();
			}else if(OpcCabeza1.equals("Macrocef�lico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[23]")).click();
			}else if(OpcCabeza1.equals("Plagiocefalico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[24]")).click();
			}
			if(OpcCabeza2.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[25]")).click();
			}else if(OpcCabeza2.equals("Descamaci�n")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[26]")).click();
			}else if(OpcCabeza2.equals("alopecia aerata")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[27]")).click();
			}else if(OpcCabeza2.equals("Alopecia generalizada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[28]")).click();
			}
			if(OpcCabeza3.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[29]")).click();
			}else if(OpcCabeza3.equals("Asimetr�ca")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[30]")).click();
			}else if(OpcCabeza3.equals("Abotagada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[31]")).click();
			}else if(OpcCabeza3.equals("Cushinoide")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[32]")).click();
			}
			if(OpcCabeza4.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[33]")).click();
			}else if(OpcCabeza4.equals("Protuberante")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[34]")).click();
			}
			if(!OpcCabeza5.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[2]")).sendKeys(OpcCabeza5);
			}
			driver.findElement(OpcionCabeza).click();
		}
		
		//Diligencionamiento Campos OJOS
		String OpcOjo1 = getCellValueSString(a, 12, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		String OpcOjo2 = getCellValueSString(a, 13, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		String OpcOjo3 = getCellValueSString(a, 14, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcOjo4 = getCellValueSString(a, 15, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		String OpcOjo5 = getCellValueSString(a, 16, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		String OpcOjo6 = getCellValueSString(a, 17, "ExamenFisico","Historia Clinica Medicina de Urgencia");
		if(OpcOjo1.equals("")&&OpcOjo2.equals("")&&OpcOjo3.equals("")&&OpcOjo4.equals("")&&OpcOjo5.equals("")&&OpcOjo6.equals("")) {
			System.out.println("No se selecciono alguna opcion de Cabeza");
		}else {
			driver.findElement(OpcionOjo).click();
			if(OpcOjo1.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[35]")).click();
			}else if(OpcOjo1.equals("Hipocromicas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[36]")).click();
			}else if(OpcOjo1.equals("Secreci�n Clara")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[37]")).click();
			}else if(OpcOjo1.equals("Sereci�n Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[38]")).click();
			}
			if(OpcOjo2.equals("Normales")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[39]")).click();
			}else if(OpcOjo2.equals("Ict�ricas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[40]")).click();
			}else if(OpcOjo2.equals("Pterigios")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[41]")).click();
			}else if(OpcOjo2.equals("Cuerpo ExtrAño")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[42]")).click();
			}
			if(OpcOjo3.equals("Isoc�ricas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[43]")).click();
			}else if(OpcOjo3.equals("Anisic�ricas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[44]")).click();
			}
			if(OpcOjo4.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[45]")).click();
			}else if(OpcOjo4.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[46]")).click();
			}
			if(OpcOjo5.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[47]")).click();
			}else if(OpcOjo5.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[48]")).click();
			}
			if(!OpcOjo6.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[3]")).sendKeys(OpcOjo6);
			}
			driver.findElement(OpcionOjo).click();
		}
		
		// Diligencionamiento Campos Nar�z
		String OpcNariz1 = getCellValueSString(b, 1, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcNariz2 = getCellValueSString(b, 2, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcNariz3 = getCellValueSString(b, 3, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcNariz4 = getCellValueSString(b, 4, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcNariz5 = getCellValueSString(b, 5, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		if (OpcNariz1.equals("") && OpcNariz2.equals("") && OpcNariz3.equals("") && OpcNariz4.equals("") && OpcNariz5.equals("")) {
			System.out.println("No se selecciono alguna opcion de Nariz");
		} else {		
			driver.findElement(OpcionNariz).click();
			if (OpcNariz1.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[49]")).click();
			} else if (OpcNariz1.equals("Grande")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[50]")).click();
			} 
			if (OpcNariz2.equals("Ausente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[51]")).click();
			} else if (OpcNariz2.equals("Presente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[52]")).click();
			} 
			if (OpcNariz3.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[53]")).click();
			} else if (OpcNariz3.equals("P�lida")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[54]")).click();
			}else if (OpcNariz3.equals("Hiper�mica")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[55]")).click();
			}else if (OpcNariz3.equals("Cornetes  Hipertr�ficos")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[56]")).click();
			}
			if (OpcNariz4.equals("Ausente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[57]")).click();
			} else if (OpcNariz4.equals("Mucoide")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[58]")).click();
			}else if (OpcNariz4.equals("Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[59]")).click();
			}else if (OpcNariz4.equals("Epistaxis")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[60]")).click();
			}			
			if (!OpcNariz5.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[3]")).sendKeys(OpcNariz5);
			}
			driver.findElement(OpcionNariz).click();
		}
		
		//  Campos O�dos
		String OpcOidos1 = getCellValueSString(b, 6, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcOidos2 = getCellValueSString(b, 7, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcOidos3 = getCellValueSString(b, 8, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcOidos4 = getCellValueSString(b, 9, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcOidos5 = getCellValueSString(b, 10, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcOidos6 = getCellValueSString(b, 11, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcOidos7 = getCellValueSString(b, 12, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcOidos8 = getCellValueSString(b, 13, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		String OpcOidos9 = getCellValueSString(b, 14, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
		if (OpcOidos1.equals("") && OpcOidos2.equals("") && OpcOidos3.equals("") && OpcOidos4.equals("")
				&& OpcOidos5.equals("") && OpcOidos6.equals("") && OpcOidos7.equals("") && OpcOidos8.equals("")
				&& OpcOidos9.equals("")) {
			System.out.println("No se selecciono alguna opcion de O�do");
		} else {			
			driver.findElement(OpcionOidos).click();
			if (OpcOidos1.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[61]")).click();
			} else if (OpcOidos1.equals("Secreci�n Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[62]")).click();
			} else if (OpcOidos1.equals("Cuerpo ExtrAño")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[63]")).click();
			} else if (OpcOidos1.equals("Tap�n de Cerumen")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[64]")).click();
			} 
			if (OpcOidos2.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[65]")).click();
			} else if (OpcOidos2.equals("Secreci�n Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[66]")).click();
			}  else if (OpcOidos2.equals("Cuerpo ExtrAño")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[67]")).click();
			} else if (OpcOidos2.equals("Tap�n de Cerumen")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[68]")).click();
			} 
			if (OpcOidos3.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[69]")).click();
			} else if (OpcOidos3.equals("Opacidad")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[70]")).click();
			}else if (OpcOidos3.equals("Perforacion")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[71]")).click();
			}
			if (OpcOidos4.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[72]")).click();
			} else if (OpcOidos4.equals("Opacidad")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[73]")).click();
			}else if (OpcOidos4.equals("Perforacion")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[74]")).click();
			}	
			if (OpcOidos5.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[75]")).click();
			} else if (OpcOidos5.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[76]")).click();
			}
			if (OpcOidos6.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[77]")).click();
			} else if (OpcOidos6.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[78]")).click();
			}if (OpcOidos7.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[79]")).click();
			} else if (OpcOidos7.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[80]")).click();
			}
			if (OpcOidos8.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[81]")).click();
			} else if (OpcOidos8.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[82]")).click();
			}
			if (!OpcOidos9.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[4]")).sendKeys(OpcOidos9);
			}
			driver.findElement(OpcionOidos).click();
		}
		
	//  Campos Boca
			String OpcBoca1 = getCellValueSString(c, 1, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
			String OpcBoca2 = getCellValueSString(c, 2, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
			String OpcBoca3 = getCellValueSString(c, 3, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
			String OpcBoca4 = getCellValueSString(c, 4, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
			String OpcBoca5 = getCellValueSString(c, 5, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
			String OpcBoca6 = getCellValueSString(c, 6, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
			String OpcBoca7 = getCellValueSString(c, 7, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
			String OpcBoca8 = getCellValueSString(c, 8, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
			if (OpcBoca1.equals("") && OpcBoca2.equals("") && OpcBoca3.equals("") && OpcBoca4.equals("")
					&& OpcBoca5.equals("") && OpcBoca6.equals("") && OpcBoca7.equals("")&& OpcBoca8.equals("")) {
				System.out.println("No se selecciono alguna opcion de Boca");
			} else {				
				driver.findElement(OpcionBocaEF).click();
				if (OpcBoca1.equals("Normales")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[83]")).click();
				} else if (OpcBoca1.equals("Hendidura superior")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[84]")).click();
				} else if (OpcBoca1.equals("Fisurados")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[85]")).click();
				} else if (OpcBoca1.equals("Ves�culas y costras")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[86]")).click();
				} 
				if (OpcBoca2.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[87]")).click();
				} else if (OpcBoca2.equals("Alto")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[88]")).click();
				} else if (OpcBoca2.equals("Fisurado")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[89]")).click();
				} else if (OpcBoca2.equals("Hendido")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[90]")).click();
				} 
				if (OpcBoca3.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[91]")).click();
				} else if (OpcBoca3.equals("Geogr�fica")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[92]")).click();
				} else if (OpcBoca3.equals("Fisurada")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[93]")).click();
				} else if (OpcBoca3.equals("Con frenillo sublingual")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[94]")).click();
				} 
				if (OpcBoca4.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[95]")).click();
				} else if (OpcBoca4.equals("Caries")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[96]")).click();
				} else if (OpcBoca4.equals("Anodoncia")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[97]")).click();
				} else if (OpcBoca4.equals("Abceso")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[98]")).click();
				} 
				if (OpcBoca5.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[99]")).click();
				} else if (OpcBoca5.equals("Hipertr�ficas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[100]")).click();
				} else if (OpcBoca5.equals("Hiper�micas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[101]")).click();
				} else if (OpcBoca5.equals("Purulentas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[102]")).click();
				} 
				if (OpcBoca6.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[103]")).click();
				} else if (OpcBoca6.equals("Hiper�micas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[104]")).click();
				} else if (OpcBoca6.equals("Vesicular")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[105]")).click();
				}
				if (OpcBoca7.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[106]")).click();
				} else if (OpcBoca7.equals("Anormal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[107]")).click();
				}
				if (!OpcBoca8.equals("")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[5]")).sendKeys(OpcBoca8);
				}
				driver.findElement(OpcionBocaEF).click();
			}	
				//  Campos Cuello
					String OpcCuello1 = getCellValueSString(c, 9, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcCuello2 = getCellValueSString(c, 10, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcCuello3 = getCellValueSString(c, 11, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcCuello4 = getCellValueSString(c, 12, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcCuello5 = getCellValueSString(c, 13, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					if (OpcCuello1.equals("") && OpcCuello2.equals("") && OpcCuello3.equals("") && OpcCuello4.equals("")
							&& OpcCuello5.equals("")) {
						System.out.println("No se selecciono alguna opcion de Cuello");
					} else {					
						driver.findElement(OpcionCuello).click();
						if (OpcCuello1.equals("Normales")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[108]")).click();
						} else if (OpcCuello1.equals("Limitac�on de la movilidad Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[109]")).click();
						} else if (OpcCuello1.equals("Limitac�on de la movilidad Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[110]")).click();
						} else if (OpcCuello1.equals("Espasmo cervical Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[111]")).click();
						} else if (OpcCuello1.equals("Espasmo cervical Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[112]")).click();
						} 
						if (OpcCuello2.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[113]")).click();
						} else if (OpcCuello2.equals("Tiromegalia Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[114]")).click();
						} else if (OpcCuello2.equals("Tiromegalia Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[115]")).click();
						} else if (OpcCuello2.equals("N�dulo palpable Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[116]")).click();
						} else if (OpcCuello2.equals("N�dulo palpable Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[117]")).click();
						} 
						if (OpcCuello3.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[118]")).click();
						} else if (OpcCuello3.equals("Desviac�on  de la tr�quea Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[119]")).click();
						} else if (OpcCuello3.equals("Desviac�on  de la tr�quea Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[120]")).click();
						} else if (OpcCuello3.equals("Ingurgitac�on Yugular G1")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[121]")).click();
						} else if (OpcCuello3.equals("Ingurgitac�on Yugular G2")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[122]")).click();
						} else if (OpcCuello3.equals("Ingurgitac�on Yugular G3")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[123]")).click();
						} 
						if (OpcCuello4.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[124]")).click();
						} else if (OpcCuello4.equals("Cervical anterior Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[125]")).click();
						} else if (OpcCuello4.equals("Cervical anterior Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[126]")).click();
						} else if (OpcCuello4.equals("Cervical posterior Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[127]")).click();
						} else if (OpcCuello4.equals("Cervical posterior Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[128]")).click();
						}
						if (!OpcCuello5.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[6]")).sendKeys(OpcCuello5);
						}
						driver.findElement(OpcionCuello).click();
					}
				//  Campos Torax
					String OpcTorax1 = getCellValueSString(c, 14, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcTorax2 = getCellValueSString(c, 15, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcTorax3 = getCellValueSString(c, 16, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcTorax4 = getCellValueSString(c, 17, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcTorax5 = getCellValueSString(c, 18, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcTorax6 = getCellValueSString(c, 19, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcTorax7 = getCellValueSString(c, 20, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					if (OpcTorax1.equals("") && OpcTorax2.equals("") && OpcTorax3.equals("") && OpcTorax4.equals("")
							&& OpcTorax5.equals("")&& OpcTorax6.equals("")&& OpcTorax7.equals("")) {
						System.out.println("No se selecciono alguna opcion de Torax");
					} else {					
						driver.findElement(OpcionTorax).click();
						if (OpcTorax1.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[129]")).click();
						} else if (OpcTorax1.equals("Anormal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[130]")).click();
						} 
						if (OpcTorax2.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[131]")).click();
						} else if (OpcTorax2.equals("Anormal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[132]")).click();
						} 
						if (OpcTorax3.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[133]")).click();
						} else if (OpcTorax3.equals("Anormal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[134]")).click();
						} 
						if (OpcTorax4.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[135]")).click();
						} else if (OpcTorax4.equals("N�dulo Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[136]")).click();
						} else if (OpcTorax4.equals("N�dulo Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[137]")).click();
						} 
						if (OpcTorax5.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[138]")).click();
						} else if (OpcTorax5.equals("Ganglios")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[139]")).click();
						}
						if (OpcTorax6.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[140]")).click();
						} else if (OpcTorax6.equals("Ganglios")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[141]")).click();
						}
						if (!OpcTorax7.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[7]")).sendKeys(OpcTorax7);
						}
						driver.findElement(OpcionTorax).click();
					}
				//  Campos abdomen
					String OpcAbdomen1 = getCellValueSString(d, 1, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcAbdomen2 = getCellValueSString(d, 2, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcAbdomen3 = getCellValueSString(d, 3, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcAbdomen4 = getCellValueSString(d, 4, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcAbdomen5 = getCellValueSString(d, 5, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcAbdomen6 = getCellValueSString(d, 6, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					if (OpcAbdomen1.equals("") && OpcAbdomen2.equals("") && OpcAbdomen3.equals("") && OpcAbdomen4.equals("")
							&& OpcAbdomen5.equals("")&& OpcAbdomen6.equals("")) {
						System.out.println("No se selecciono alguna opcion de Abdomen");
					} else {					
						driver.findElement(OpcionAbdomen).click();
						if (OpcAbdomen1.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[142]")).click();
						} else if (OpcAbdomen1.equals("Globuloso")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[143]")).click();
						} else if (OpcAbdomen1.equals("Excavado")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[144]")).click();
						} 
						if (OpcAbdomen2.equals("Ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[145]")).click();
						} else if (OpcAbdomen2.equals("Masas Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[146]")).click();
						} else if (OpcAbdomen2.equals("Masas Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[147]")).click();
						} 
						if (OpcAbdomen3.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[148]")).click();
						} else if (OpcAbdomen3.equals("Hepatomegalia")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[149]")).click();
						} else if (OpcAbdomen3.equals("Esplenomegalia")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[150]")).click();
						} 
						if (OpcAbdomen4.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[151]")).click();
						} else if (OpcAbdomen4.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[152]")).click();
						} 
						if (OpcAbdomen5.equals("Ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[153]")).click();
						} else if (OpcAbdomen5.equals("Leve")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[154]")).click();
						}else if (OpcTorax5.equals("A tensi�n")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[155]")).click();
						}						
						if (!OpcAbdomen6.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[9]")).sendKeys(OpcAbdomen6);
						}
						driver.findElement(OpcionAbdomen).click();
					}
				//  Campos Genitales
					if(Sexo.equals("Femenino")) {
					
						String OpcGenitales1 = getCellValueSString(d, 11, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
						String OpcGenitales2 = getCellValueSString(d, 12, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
						String OpcGenitales3 = getCellValueSString(d, 13, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
						String OpcGenitales4 = getCellValueSString(d, 14, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
						String OpcGenitales5 = getCellValueSString(d, 15, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
						if (OpcGenitales1.equals("") && OpcGenitales2.equals("") && OpcGenitales3.equals("") && OpcGenitales4.equals("")
								&& OpcGenitales5.equals("")) {
							System.out.println("No se selecciono alguna opcion de Genitales Femenino");
						} else {					
							driver.findElement(OpcionGenitalesF).click();
							if (OpcAbdomen1.equals("I")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[156]")).click();
							} else if (OpcGenitales1.equals("II")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[157]")).click();
							} else if (OpcGenitales1.equals("III")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[158]")).click();
							} else if (OpcGenitales1.equals("IV")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[159]")).click();
							} else if (OpcGenitales1.equals("V")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[160]")).click();
							} 
							if (OpcGenitales2.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[161]")).click();
							} else if (OpcGenitales2.equals("Masas Der")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[162]")).click();
							} else if (OpcGenitales2.equals("Masas Izq")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[163]")).click();
							} 
							if (OpcGenitales3.equals("Normales")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[164]")).click();
							} else if (OpcGenitales3.equals("Dolor al Movilizar el c�rvix")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[165]")).click();
							} else if (OpcGenitales3.equals("Masa en cerv�x")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[166]")).click();
							} 
							if (OpcGenitales4.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[167]")).click();
							} else if (OpcGenitales4.equals("Prolapso")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[168]")).click();
							} 											
							if (!OpcGenitales5.equals("")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[10]")).sendKeys(OpcGenitales5);
							}
							driver.findElement(OpcionGenitalesF).click();
						}
					}else if(Sexo.equals("Masculino")) {
						String OpcGenitales1 = getCellValueSString(d, 11, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
						String OpcGenitales2 = getCellValueSString(d, 12, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
						String OpcGenitales3 = getCellValueSString(d, 13, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
						String OpcGenitales4 = getCellValueSString(d, 14, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
						if (OpcGenitales1.equals("") && OpcGenitales2.equals("") && OpcGenitales3.equals("") && OpcGenitales4.equals("")) {
							System.out.println("No se selecciono alguna opcion de Genitales Masculino");
						} else {					
							driver.findElement(OpcionGenitalesM).click();
							if (OpcAbdomen1.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[156]")).click();
							} else if (OpcGenitales1.equals("Masa Der")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[157]")).click();
							} else if (OpcGenitales1.equals("Masa Izq")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[158]")).click();
							} 
							if (OpcGenitales2.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[159]")).click();
							} else if (OpcGenitales2.equals("Anormal Der")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[160]")).click();
							} else if (OpcGenitales2.equals("anormal Izq")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[161]")).click();
							} 
							if (OpcGenitales3.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[162]")).click();
							} else if (OpcGenitales3.equals("Eritema")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[163]")).click();
							} else if (OpcGenitales3.equals("Secrec�on uretal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[164]")).click();
							} 									
							if (!OpcGenitales4.equals("")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[10]")).sendKeys(OpcGenitales4);
							}
							driver.findElement(OpcionGenitalesM).click();
						}
					}
					// Campos Extremidades
					String OpcExtremidad1 = getCellValueSString(e, 1, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcExtremidad2 = getCellValueSString(e, 2, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcExtremidad3 = getCellValueSString(e, 3, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcExtremidad4 = getCellValueSString(e, 4, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcExtremidad5 = getCellValueSString(e, 5, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcExtremidad6 = getCellValueSString(e, 6, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcExtremidad7 = getCellValueSString(e, 7, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcExtremidad8 = getCellValueSString(e, 8, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					if (OpcExtremidad1.equals("") && OpcExtremidad2.equals("") && OpcExtremidad3.equals("")
							&& OpcExtremidad4.equals("") && OpcExtremidad5.equals("") && OpcExtremidad6.equals("")
							&& OpcExtremidad7.equals("") && OpcExtremidad8.equals("")) {
						System.out.println("No se selecciono alguna opcion de Extremidades");
					} else {				
						driver.findElement(OpcionExtremidades).click();
						if (OpcExtremidad1.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[1]")).click();
						} else if (OpcExtremidad1.equals("Hipotrofia leve")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[2]")).click();
						} else if (OpcExtremidad1.equals("Hipotrofia moderada")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[3]")).click();
						} else if (OpcExtremidad1.equals("Hipotrofia severa")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[4]")).click();
						} 
						if (OpcExtremidad2.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[5]")).click();
						} else if (OpcExtremidad2.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[6]")).click();
						} 
						if (OpcExtremidad3.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[7]")).click();
						} else if (OpcExtremidad3.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[8]")).click();
						} 
						if (OpcExtremidad4.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[9]")).click();
						} else if (OpcExtremidad4.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[10]")).click();
						} 
						if (OpcExtremidad5.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[11]")).click();
						} else if (OpcExtremidad5.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[12]")).click();
						} 
						if (OpcExtremidad6.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[13]")).click();
						} else if (OpcExtremidad6.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[14]")).click();
						} 
						if (OpcExtremidad7.equals("SI")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[15]")).click();
						} else if (OpcExtremidad7.equals("NO")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[16]")).click();
						} 
						if (!OpcExtremidad8.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[11]")).sendKeys(OpcExtremidad8);
						}
						driver.findElement(OpcionExtremidades).click();
					}
					// Campos Piel
					String OpcPiel1 = getCellValueSString(e, 9, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcPiel2 = getCellValueSString(e, 10, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcPiel3 = getCellValueSString(e, 11, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcPiel4 = getCellValueSString(e, 12, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcPiel5 = getCellValueSString(e, 13, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					if (OpcPiel1.equals("") && OpcPiel2.equals("") && OpcPiel3.equals("")
							&& OpcPiel4.equals("") && OpcPiel5.equals("")) {
						System.out.println("No se selecciono alguna opcion de Piel");
					} else {				
						driver.findElement(OpcionPiel).click();
						if (OpcPiel1.equals("Ausente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[1]")).click();
						} else if (OpcPiel1.equals("Presente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}
						if (OpcPiel2.equals("Ausente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[3]")).click();
						} else if (OpcPiel2.equals("Presente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[4]")).click();
						}
						if (OpcPiel3.equals("Ausente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[5]")).click();
						} else if (OpcPiel3.equals("Presente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[6]")).click();
						} 
						if (OpcPiel4.equals("Ausente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[7]")).click();
						} else if (OpcPiel4.equals("Presente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[8]")).click();
						}
						if (!OpcPiel5.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[12]")).sendKeys(OpcPiel5);
						}
						driver.findElement(OpcionPiel).click();
					}
					// Campos Neurologico
					String OpcNeu1 = getCellValueSString(e, 14, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcNeu2 = getCellValueSString(e, 15, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcNeu3 = getCellValueSString(e, 16, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcNeu4 = getCellValueSString(e, 17, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcNeu5 = getCellValueSString(e, 18, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcNeu6 = getCellValueSString(e, 19, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					if (OpcNeu1.equals("") && OpcNeu2.equals("") && OpcNeu3.equals("")
							&& OpcNeu4.equals("") && OpcNeu5.equals("")&& OpcNeu6.equals("")) {
						System.out.println("No se selecciono alguna opcion de Extremidades");
					} else {				
						driver.findElement(OpcionNeurologico).click();
						if (OpcNeu1.equals("Cognicion")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[1]")).click();
						} else if (OpcNeu1.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}else if (OpcNeu1.equals("Memorial")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}else if (OpcNeu1.equals("C�lculo")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}else if (OpcNeu1.equals("Orientac�on")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}
						if (OpcNeu2.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[3]")).click();
						} else if (OpcNeu2.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[4]")).click();
						}
						if (OpcNeu3.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[5]")).click();
						} else if (OpcNeu3.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[6]")).click();
						} 
						if (OpcNeu4.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[7]")).click();
						} else if (OpcNeu4.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[8]")).click();
						}
						if (OpcNeu5.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[9]")).click();
						} else if (OpcNeu5.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[10]")).click();
						}
						if (!OpcPiel5.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[12]")).sendKeys(OpcPiel5);
						}
						driver.findElement(OpcionNeurologico).click();
					}
					// Campos Ex�men Psiquiatrico
					String OpcEP1 = getCellValueSString(f, 1, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcEP2 = getCellValueSString(f, 2, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcEP3 = getCellValueSString(f, 3, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcEP4 = getCellValueSString(f, 4, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					String OpcEP5 = getCellValueSString(f, 5, "ExamenFisico", "Historia Clinica Medicina de Urgencia");
					if (OpcEP1.equals("") && OpcEP2.equals("") && OpcEP3.equals("")
							&& OpcEP4.equals("") && OpcEP5.equals("")) {
						System.out.println("No se selecciono alguna opcion de Ex�men Psiqui�trico");
					} else {				
						driver.findElement(OpcionEP).click();
						if (OpcEP1.equals("Normal ")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[1]")).click();
						} else if (OpcEP1.equals("Globuloso")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}else if (OpcEP1.equals("Excavado")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}
						if (OpcEP2.equals("Ausente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[3]")).click();
						} else if (OpcEP2.equals("Masas Der")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[4]")).click();
						}else if (OpcEP2.equals("Masas Izq")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[4]")).click();
						}
						if (OpcEP3.equals("ausente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[5]")).click();
						} else if (OpcEP3.equals("Hepatomegalia")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[6]")).click();
						} else if (OpcEP3.equals("Esplenomegalia")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[6]")).click();
						} 
						if (OpcEP4.equals("ausente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[7]")).click();
						} else if (OpcEP4.equals("Presente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[8]")).click();
						}						
						if (!OpcEP5.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[14]")).sendKeys(OpcEP5);
						}
						driver.findElement(OpcionEP).click();
					}			
	}
	
	public void ExamenFisicoPediatria(WebDriver driver, int a, int b, int c, int d, int e, int f,int g,int h) throws IOException, InterruptedException {
		String Sexo=driver.findElement(SexoPaciente).getText().strip();
		driver.findElement(OpcionExamenFisico).click();
		Thread.sleep(1000);
		// Inspecci�n General		
		String Opc1 = getCellValueSString(a, 1, "ExamenFisico","Historia Clinica Pediatria");
		String Opc2 = getCellValueSString(a, 2, "ExamenFisico","Historia Clinica Pediatria");
		String Opc3 = getCellValueSString(a, 3, "ExamenFisico", "Historia Clinica Pediatria");
		String Opc4 = getCellValueSString(a, 4, "ExamenFisico","Historia Clinica Pediatria");
		String Opc5 = getCellValueSString(a, 5, "ExamenFisico","Historia Clinica Pediatria");
		String Opc6 = getCellValueSString(a, 6, "ExamenFisico","Historia Clinica Pediatria");
		
		if(Opc1.equals("")&&Opc2.equals("")&&Opc3.equals("")&&Opc4.equals("")&&Opc5.equals("")&&Opc6.equals("")) {
			System.out.println("No se selecciono alguna opcion de Inspeccion General");
		}else {
			if(Opc1.equals("Alerta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[1]")).click();
			}else if(Opc1.equals("Somnoliento")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[2]")).click();
			}else if(Opc1.equals("Estuporoso")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[3]")).click();
			}else if(Opc1.equals("Comatoso")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[4]")).click();
			}
			if(Opc2.equals("Ausente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[5]")).click();
			}else if(Opc2.equals("Leve")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[6]")).click();
			}else if(Opc2.equals("Moderada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[7]")).click();
			}else if(Opc2.equals("Severa")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[8]")).click();
			}
			if(Opc3.equals("Colaborador")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[9]")).click();
			}else if(Opc3.equals("Medianamente Colaborador")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[10]")).click();
			}else if(Opc3.equals("Algo colaborador")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[11]")).click();
			}else if(Opc3.equals("No Colabora con  EF")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[12]")).click();
			}
			if(Opc4.equals("Sin restric�on")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[13]")).click();
			}else if(Opc4.equals("Restricc�on Leve")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[14]")).click();
			}else if(Opc4.equals("Restricc�on Moderada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[15]")).click();
			}else if(Opc4.equals("Postrado")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[16]")).click();
			}
			if(Opc5.equals("Eutr�fico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[17]")).click();
			}else if(Opc5.equals("Obeso")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[18]")).click();
			}else if(Opc5.equals("Anor�xico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[19]")).click();
			}else if(Opc5.equals("Caqu�tico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[20]")).click();
			}
			if(!Opc6.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[1]")).sendKeys(Opc6);
			}
			driver.findElement(OpcionInspeccionGeneral).click();
		}
		
        //Campos Cabeza
		String OpcCabeza1 = getCellValueSString(a, 7, "ExamenFisico","Historia Clinica Pediatria");
		String OpcCabeza2 = getCellValueSString(a, 8, "ExamenFisico","Historia Clinica Pediatria");
		String OpcCabeza3 = getCellValueSString(a, 9, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcCabeza4 = getCellValueSString(a, 10, "ExamenFisico","Historia Clinica Pediatria");
		String OpcCabeza5 = getCellValueSString(a, 11, "ExamenFisico","Historia Clinica Pediatria");
		if(OpcCabeza1.equals("")&&OpcCabeza2.equals("")&&OpcCabeza3.equals("")&&OpcCabeza4.equals("")&&OpcCabeza5.equals("")) {
			System.out.println("No se selecciono alguna opcion de Cabeza");
		}else {
			driver.findElement(OpcionCabeza).click();
			if(OpcCabeza1.equals("Normocr�neo")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[21]")).click();
			}else if(OpcCabeza1.equals("Microcef�lico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[22]")).click();
			}else if(OpcCabeza1.equals("Macrocef�lico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[23]")).click();
			}else if(OpcCabeza1.equals("Plagiocefalico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[24]")).click();
			}
			if(OpcCabeza2.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[25]")).click();
			}else if(OpcCabeza2.equals("Descamaci�n")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[26]")).click();
			}else if(OpcCabeza2.equals("alopecia aerata")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[27]")).click();
			}else if(OpcCabeza2.equals("Alopecia generalizada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[28]")).click();
			}
			if(OpcCabeza3.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[29]")).click();
			}else if(OpcCabeza3.equals("Asimetr�ca")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[30]")).click();
			}else if(OpcCabeza3.equals("Abotagada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[31]")).click();
			}else if(OpcCabeza3.equals("Cushinoide")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[32]")).click();
			}
			if(OpcCabeza4.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[33]")).click();
			}else if(OpcCabeza4.equals("Protuberante")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[34]")).click();
			}
			if(!OpcCabeza5.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[2]")).sendKeys(OpcCabeza5);
			}
			driver.findElement(OpcionCabeza).click();
		}
		
		//Diligencionamiento Campos OJOS
		String OpcOjo1 = getCellValueSString(a, 12, "ExamenFisico","Historia Clinica Pediatria");
		String OpcOjo2 = getCellValueSString(a, 13, "ExamenFisico","Historia Clinica Pediatria");
		String OpcOjo3 = getCellValueSString(a, 14, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcOjo4 = getCellValueSString(a, 15, "ExamenFisico","Historia Clinica Pediatria");
		String OpcOjo5 = getCellValueSString(a, 16, "ExamenFisico","Historia Clinica Pediatria");
		String OpcOjo6 = getCellValueSString(a, 17, "ExamenFisico","Historia Clinica Pediatria");
		if(OpcOjo1.equals("")&&OpcOjo2.equals("")&&OpcOjo3.equals("")&&OpcOjo4.equals("")&&OpcOjo5.equals("")&&OpcOjo6.equals("")) {
			System.out.println("No se selecciono alguna opcion de Cabeza");
		}else {
			driver.findElement(OpcionOjo).click();
			if(OpcOjo1.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[35]")).click();
			}else if(OpcOjo1.equals("Hipocromicas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[36]")).click();
			}else if(OpcOjo1.equals("Secreci�n Clara")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[37]")).click();
			}else if(OpcOjo1.equals("Sereci�n Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[38]")).click();
			}
			if(OpcOjo2.equals("Normales")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[39]")).click();
			}else if(OpcOjo2.equals("Ict�ricas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[40]")).click();
			}else if(OpcOjo2.equals("Pterigios")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[41]")).click();
			}else if(OpcOjo2.equals("Cuerpo ExtrAño")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[42]")).click();
			}
			if(OpcOjo3.equals("Isoc�ricas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[43]")).click();
			}else if(OpcOjo3.equals("Anisic�ricas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[44]")).click();
			}
			if(OpcOjo4.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[45]")).click();
			}else if(OpcOjo4.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[46]")).click();
			}
			if(OpcOjo5.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[47]")).click();
			}else if(OpcOjo5.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[48]")).click();
			}
			if(!OpcOjo6.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[3]")).sendKeys(OpcOjo6);
			}
			driver.findElement(OpcionOjo).click();
		}
		
		// Diligencionamiento Campos Nar�z
		String OpcNariz1 = getCellValueSString(b, 1, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcNariz2 = getCellValueSString(b, 2, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcNariz3 = getCellValueSString(b, 3, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcNariz4 = getCellValueSString(b, 4, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcNariz5 = getCellValueSString(b, 5, "ExamenFisico", "Historia Clinica Pediatria");
		if (OpcNariz1.equals("") && OpcNariz2.equals("") && OpcNariz3.equals("") && OpcNariz4.equals("") && OpcNariz5.equals("")) {
			System.out.println("No se selecciono alguna opcion de Nariz");
		} else {		
			driver.findElement(OpcionNariz).click();
			if (OpcNariz1.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[49]")).click();
			} else if (OpcNariz1.equals("Grande")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[50]")).click();
			} 
			if (OpcNariz2.equals("Ausente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[51]")).click();
			} else if (OpcNariz2.equals("Presente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[52]")).click();
			} 
			if (OpcNariz3.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[53]")).click();
			} else if (OpcNariz3.equals("P�lida")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[54]")).click();
			}else if (OpcNariz3.equals("Hiper�mica")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[55]")).click();
			}else if (OpcNariz3.equals("Cornetes  Hipertr�ficos")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[56]")).click();
			}
			if (OpcNariz4.equals("Ausente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[57]")).click();
			} else if (OpcNariz4.equals("Mucoide")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[58]")).click();
			}else if (OpcNariz4.equals("Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[59]")).click();
			}else if (OpcNariz4.equals("Epistaxis")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[60]")).click();
			}			
			if (!OpcNariz5.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[3]")).sendKeys(OpcNariz5);
			}
			driver.findElement(OpcionNariz).click();
		}
		
		//  Campos O�dos
		String OpcOidos1 = getCellValueSString(b, 6, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcOidos2 = getCellValueSString(b, 7, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcOidos3 = getCellValueSString(b, 8, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcOidos4 = getCellValueSString(b, 9, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcOidos5 = getCellValueSString(b, 10, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcOidos6 = getCellValueSString(b, 11, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcOidos7 = getCellValueSString(b, 12, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcOidos8 = getCellValueSString(b, 13, "ExamenFisico", "Historia Clinica Pediatria");
		String OpcOidos9 = getCellValueSString(b, 14, "ExamenFisico", "Historia Clinica Pediatria");
		if (OpcOidos1.equals("") && OpcOidos2.equals("") && OpcOidos3.equals("") && OpcOidos4.equals("")
				&& OpcOidos5.equals("") && OpcOidos6.equals("") && OpcOidos7.equals("") && OpcOidos8.equals("")
				&& OpcOidos9.equals("")) {
			System.out.println("No se selecciono alguna opcion de O�do");
		} else {			
			driver.findElement(OpcionOidos).click();
			if (OpcOidos1.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[61]")).click();
			} else if (OpcOidos1.equals("Secreci�n Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[62]")).click();
			} else if (OpcOidos1.equals("Cuerpo ExtrAño")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[63]")).click();
			} else if (OpcOidos1.equals("Tap�n de Cerumen")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[64]")).click();
			} 
			if (OpcOidos2.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[65]")).click();
			} else if (OpcOidos2.equals("Secreci�n Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[66]")).click();
			}  else if (OpcOidos2.equals("Cuerpo ExtrAño")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[67]")).click();
			} else if (OpcOidos2.equals("Tap�n de Cerumen")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[68]")).click();
			} 
			if (OpcOidos3.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[69]")).click();
			} else if (OpcOidos3.equals("Opacidad")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[70]")).click();
			}else if (OpcOidos3.equals("Perforacion")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[71]")).click();
			}
			if (OpcOidos4.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[72]")).click();
			} else if (OpcOidos4.equals("Opacidad")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[73]")).click();
			}else if (OpcOidos4.equals("Perforacion")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[74]")).click();
			}	
			if (OpcOidos5.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[75]")).click();
			} else if (OpcOidos5.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[76]")).click();
			}
			if (OpcOidos6.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[77]")).click();
			} else if (OpcOidos6.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[78]")).click();
			}if (OpcOidos7.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[79]")).click();
			} else if (OpcOidos7.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[80]")).click();
			}
			if (OpcOidos8.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[81]")).click();
			} else if (OpcOidos8.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[82]")).click();
			}
			if (!OpcOidos9.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[4]")).sendKeys(OpcOidos9);
			}
			driver.findElement(OpcionOidos).click();
		}
		
	//  Campos Boca
			String OpcBoca1 = getCellValueSString(c, 1, "ExamenFisico", "Historia Clinica Pediatria");
			String OpcBoca2 = getCellValueSString(c, 2, "ExamenFisico", "Historia Clinica Pediatria");
			String OpcBoca3 = getCellValueSString(c, 3, "ExamenFisico", "Historia Clinica Pediatria");
			String OpcBoca4 = getCellValueSString(c, 4, "ExamenFisico", "Historia Clinica Pediatria");
			String OpcBoca5 = getCellValueSString(c, 5, "ExamenFisico", "Historia Clinica Pediatria");
			String OpcBoca6 = getCellValueSString(c, 6, "ExamenFisico", "Historia Clinica Pediatria");
			String OpcBoca7 = getCellValueSString(c, 7, "ExamenFisico", "Historia Clinica Pediatria");
			String OpcBoca8 = getCellValueSString(c, 8, "ExamenFisico", "Historia Clinica Pediatria");
			if (OpcBoca1.equals("") && OpcBoca2.equals("") && OpcBoca3.equals("") && OpcBoca4.equals("")
					&& OpcBoca5.equals("") && OpcBoca6.equals("") && OpcBoca7.equals("")&& OpcBoca8.equals("")) {
				System.out.println("No se selecciono alguna opcion de Boca");
			} else {				
				driver.findElement(OpcionBocaEF).click();
				if (OpcBoca1.equals("Normales")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[83]")).click();
				} else if (OpcBoca1.equals("Hendidura superior")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[84]")).click();
				} else if (OpcBoca1.equals("Fisurados")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[85]")).click();
				} else if (OpcBoca1.equals("Ves�culas y costras")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[86]")).click();
				} 
				if (OpcBoca2.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[87]")).click();
				} else if (OpcBoca2.equals("Alto")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[88]")).click();
				} else if (OpcBoca2.equals("Fisurado")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[89]")).click();
				} else if (OpcBoca2.equals("Hendido")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[90]")).click();
				} 
				if (OpcBoca3.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[91]")).click();
				} else if (OpcBoca3.equals("Geogr�fica")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[92]")).click();
				} else if (OpcBoca3.equals("Fisurada")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[93]")).click();
				} else if (OpcBoca3.equals("Con frenillo sublingual")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[94]")).click();
				} 
				if (OpcBoca4.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[95]")).click();
				} else if (OpcBoca4.equals("Caries")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[96]")).click();
				} else if (OpcBoca4.equals("Anodoncia")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[97]")).click();
				} else if (OpcBoca4.equals("Abceso")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[98]")).click();
				} 
				if (OpcBoca5.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[99]")).click();
				} else if (OpcBoca5.equals("Hipertr�ficas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[100]")).click();
				} else if (OpcBoca5.equals("Hiper�micas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[101]")).click();
				} else if (OpcBoca5.equals("Purulentas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[102]")).click();
				} 
				if (OpcBoca6.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[103]")).click();
				} else if (OpcBoca6.equals("Hiper�micas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[104]")).click();
				} else if (OpcBoca6.equals("Vesicular")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[105]")).click();
				}
				if (OpcBoca7.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[106]")).click();
				} else if (OpcBoca7.equals("Anormal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[107]")).click();
				}
				if (!OpcBoca8.equals("")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[5]")).sendKeys(OpcBoca8);
				}
				driver.findElement(OpcionBocaEF).click();
			}
			
				//  Campos Cuello
					String OpcCuello1 = getCellValueSString(c, 9, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcCuello2 = getCellValueSString(c, 10, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcCuello3 = getCellValueSString(c, 11, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcCuello4 = getCellValueSString(c, 12, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcCuello5 = getCellValueSString(c, 13, "ExamenFisico", "Historia Clinica Pediatria");
					if (OpcCuello1.equals("") && OpcCuello2.equals("") && OpcCuello3.equals("") && OpcCuello4.equals("")
							&& OpcCuello5.equals("")) {
						System.out.println("No se selecciono alguna opcion de Cuello");
					} else {					
						driver.findElement(OpcionCuello).click();
						if (OpcCuello1.equals("Normales")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[108]")).click();
						} else if (OpcCuello1.equals("Limitac�on de la movilidad Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[109]")).click();
						} else if (OpcCuello1.equals("Limitac�on de la movilidad Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[110]")).click();
						} else if (OpcCuello1.equals("Espasmo cervical Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[111]")).click();
						} else if (OpcCuello1.equals("Espasmo cervical Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[112]")).click();
						} 
						if (OpcCuello2.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[113]")).click();
						} else if (OpcCuello2.equals("Tiromegalia Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[114]")).click();
						} else if (OpcCuello2.equals("Tiromegalia Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[115]")).click();
						} else if (OpcCuello2.equals("N�dulo palpable Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[116]")).click();
						} else if (OpcCuello2.equals("N�dulo palpable Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[117]")).click();
						} 
						if (OpcCuello3.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[118]")).click();
						} else if (OpcCuello3.equals("Desviac�on  de la tr�quea Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[119]")).click();
						} else if (OpcCuello3.equals("Desviac�on  de la tr�quea Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[120]")).click();
						} else if (OpcCuello3.equals("Ingurgitac�on Yugular G1")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[121]")).click();
						} else if (OpcCuello3.equals("Ingurgitac�on Yugular G2")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[122]")).click();
						} else if (OpcCuello3.equals("Ingurgitac�on Yugular G3")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[123]")).click();
						} 
						if (OpcCuello4.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[124]")).click();
						} else if (OpcCuello4.equals("Cervical anterior Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[125]")).click();
						} else if (OpcCuello4.equals("Cervical anterior Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[126]")).click();
						} else if (OpcCuello4.equals("Cervical posterior Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[127]")).click();
						} else if (OpcCuello4.equals("Cervical posterior Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[128]")).click();
						}
						if (!OpcCuello5.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[6]")).sendKeys(OpcCuello5);
						}
						driver.findElement(OpcionCuello).click();
					}
				//  Campos Torax
					String OpcTorax1 = getCellValueSString(c, 14, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcTorax2 = getCellValueSString(c, 15, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcTorax3 = getCellValueSString(c, 16, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcTorax4 = getCellValueSString(c, 17, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcTorax5 = getCellValueSString(c, 18, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcTorax6 = getCellValueSString(c, 19, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcTorax7 = getCellValueSString(c, 20, "ExamenFisico", "Historia Clinica Pediatria");
					if (OpcTorax1.equals("") && OpcTorax2.equals("") && OpcTorax3.equals("") && OpcTorax4.equals("")
							&& OpcTorax5.equals("")&& OpcTorax6.equals("")&& OpcTorax7.equals("")) {
						System.out.println("No se selecciono alguna opcion de Torax");
					} else {					
						driver.findElement(OpcionTorax).click();
						if (OpcTorax1.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[129]")).click();
						} else if (OpcTorax1.equals("Anormal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[130]")).click();
						} 
						if (OpcTorax2.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[131]")).click();
						} else if (OpcTorax2.equals("Anormal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[132]")).click();
						} 
						if (OpcTorax3.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[133]")).click();
						} else if (OpcTorax3.equals("Anormal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[134]")).click();
						} 
						if (OpcTorax4.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[135]")).click();
						} else if (OpcTorax4.equals("N�dulo Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[136]")).click();
						} else if (OpcTorax4.equals("N�dulo Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[137]")).click();
						} 
						if (OpcTorax5.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[138]")).click();
						} else if (OpcTorax5.equals("Ganglios")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[139]")).click();
						}
						if (OpcTorax6.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[140]")).click();
						} else if (OpcTorax6.equals("Ganglios")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[141]")).click();
						}
						if (!OpcTorax7.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[7]")).sendKeys(OpcTorax7);
						}
						driver.findElement(OpcionTorax).click();
					}
				//  Campos abdomen
					String OpcAbdomen1 = getCellValueSString(d, 1, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcAbdomen2 = getCellValueSString(d, 2, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcAbdomen3 = getCellValueSString(d, 3, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcAbdomen4 = getCellValueSString(d, 4, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcAbdomen5 = getCellValueSString(d, 5, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcAbdomen6 = getCellValueSString(d, 6, "ExamenFisico", "Historia Clinica Pediatria");
					if (OpcAbdomen1.equals("") && OpcAbdomen2.equals("") && OpcAbdomen3.equals("") && OpcAbdomen4.equals("")
							&& OpcAbdomen5.equals("")&& OpcAbdomen6.equals("")) {
						System.out.println("No se selecciono alguna opcion de Abdomen");
					} else {					
						driver.findElement(OpcionAbdomen).click();
						if (OpcAbdomen1.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[142]")).click();
						} else if (OpcAbdomen1.equals("Globuloso")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[143]")).click();
						} else if (OpcAbdomen1.equals("Excavado")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[144]")).click();
						} 
						if (OpcAbdomen2.equals("Ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[145]")).click();
						} else if (OpcAbdomen2.equals("Masas Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[146]")).click();
						} else if (OpcAbdomen2.equals("Masas Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[147]")).click();
						} 
						if (OpcAbdomen3.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[148]")).click();
						} else if (OpcAbdomen3.equals("Hepatomegalia")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[149]")).click();
						} else if (OpcAbdomen3.equals("Esplenomegalia")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[150]")).click();
						} 
						if (OpcAbdomen4.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[151]")).click();
						} else if (OpcAbdomen4.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[152]")).click();
						} 
						if (OpcAbdomen5.equals("Ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[153]")).click();
						} else if (OpcAbdomen5.equals("Leve")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[154]")).click();
						}else if (OpcTorax5.equals("A tensi�n")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[155]")).click();
						}						
						if (!OpcAbdomen6.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[9]")).sendKeys(OpcAbdomen6);
						}
						driver.findElement(OpcionAbdomen).click();
					}
				//  Campos Genitales
					if(Sexo.equals("Femenino")) {
					
						String OpcGenitales1 = getCellValueSString(d, 11, "ExamenFisico", "Historia Clinica Pediatria");
						String OpcGenitales2 = getCellValueSString(d, 12, "ExamenFisico", "Historia Clinica Pediatria");
						String OpcGenitales3 = getCellValueSString(d, 13, "ExamenFisico", "Historia Clinica Pediatria");
						String OpcGenitales4 = getCellValueSString(d, 14, "ExamenFisico", "Historia Clinica Pediatria");
						String OpcGenitales5 = getCellValueSString(d, 15, "ExamenFisico", "Historia Clinica Pediatria");
						if (OpcGenitales1.equals("") && OpcGenitales2.equals("") && OpcGenitales3.equals("") && OpcGenitales4.equals("")
								&& OpcGenitales5.equals("")) {
							System.out.println("No se selecciono alguna opcion de Genitales Femenino");
						} else {					
							driver.findElement(OpcionGenitalesF).click();
							if (OpcAbdomen1.equals("I")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[156]")).click();
							} else if (OpcGenitales1.equals("II")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[157]")).click();
							} else if (OpcGenitales1.equals("III")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[158]")).click();
							} else if (OpcGenitales1.equals("IV")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[159]")).click();
							} else if (OpcGenitales1.equals("V")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[160]")).click();
							} 
							if (OpcGenitales2.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[161]")).click();
							} else if (OpcGenitales2.equals("Masas Der")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[162]")).click();
							} else if (OpcGenitales2.equals("Masas Izq")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[163]")).click();
							} 
							if (OpcGenitales3.equals("Normales")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[164]")).click();
							} else if (OpcGenitales3.equals("Dolor al Movilizar el c�rvix")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[165]")).click();
							} else if (OpcGenitales3.equals("Masa en cerv�x")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[166]")).click();
							} 
							if (OpcGenitales4.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[167]")).click();
							} else if (OpcGenitales4.equals("Prolapso")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[168]")).click();
							} 											
							if (!OpcGenitales5.equals("")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[10]")).sendKeys(OpcGenitales5);
							}
							driver.findElement(OpcionGenitalesF).click();
						}
					}else if(Sexo.equals("Masculino")) {
						String OpcGenitales1 = getCellValueSString(d, 11, "ExamenFisico", "Historia Clinica Pediatria");
						String OpcGenitales2 = getCellValueSString(d, 12, "ExamenFisico", "Historia Clinica Pediatria");
						String OpcGenitales3 = getCellValueSString(d, 13, "ExamenFisico", "Historia Clinica Pediatria");
						String OpcGenitales4 = getCellValueSString(d, 14, "ExamenFisico", "Historia Clinica Pediatria");
						if (OpcGenitales1.equals("") && OpcGenitales2.equals("") && OpcGenitales3.equals("") && OpcGenitales4.equals("")) {
							System.out.println("No se selecciono alguna opcion de Genitales Masculino");
						} else {					
							driver.findElement(OpcionGenitalesM).click();
							if (OpcAbdomen1.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[156]")).click();
							} else if (OpcGenitales1.equals("Masa Der")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[157]")).click();
							} else if (OpcGenitales1.equals("Masa Izq")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[158]")).click();
							} 
							if (OpcGenitales2.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[159]")).click();
							} else if (OpcGenitales2.equals("Anormal Der")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[160]")).click();
							} else if (OpcGenitales2.equals("anormal Izq")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[161]")).click();
							} 
							if (OpcGenitales3.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[162]")).click();
							} else if (OpcGenitales3.equals("Eritema")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[163]")).click();
							} else if (OpcGenitales3.equals("Secrec�on uretal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[164]")).click();
							} 									
							if (!OpcGenitales4.equals("")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[10]")).sendKeys(OpcGenitales4);
							}
							driver.findElement(OpcionGenitalesM).click();
						}
					}
					// Campos Extremidades
					String OpcExtremidad1 = getCellValueSString(e, 1, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcExtremidad2 = getCellValueSString(e, 2, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcExtremidad3 = getCellValueSString(e, 3, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcExtremidad4 = getCellValueSString(e, 4, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcExtremidad5 = getCellValueSString(e, 5, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcExtremidad6 = getCellValueSString(e, 6, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcExtremidad7 = getCellValueSString(e, 7, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcExtremidad8 = getCellValueSString(e, 8, "ExamenFisico", "Historia Clinica Pediatria");
					if (OpcExtremidad1.equals("") && OpcExtremidad2.equals("") && OpcExtremidad3.equals("")
							&& OpcExtremidad4.equals("") && OpcExtremidad5.equals("") && OpcExtremidad6.equals("")
							&& OpcExtremidad7.equals("") && OpcExtremidad8.equals("")) {
						System.out.println("No se selecciono alguna opcion de Extremidades");
					} else {				
						driver.findElement(OpcionExtremidades).click();
						if (OpcExtremidad1.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[1]")).click();
						} else if (OpcExtremidad1.equals("Hipotrofia leve")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[2]")).click();
						} else if (OpcExtremidad1.equals("Hipotrofia moderada")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[3]")).click();
						} else if (OpcExtremidad1.equals("Hipotrofia severa")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[4]")).click();
						} 
						if (OpcExtremidad2.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[5]")).click();
						} else if (OpcExtremidad2.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[6]")).click();
						} 
						if (OpcExtremidad3.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[7]")).click();
						} else if (OpcExtremidad3.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[8]")).click();
						} 
						if (OpcExtremidad4.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[9]")).click();
						} else if (OpcExtremidad4.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[10]")).click();
						} 
						if (OpcExtremidad5.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[11]")).click();
						} else if (OpcExtremidad5.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[12]")).click();
						} 
						if (OpcExtremidad6.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[13]")).click();
						} else if (OpcExtremidad6.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[14]")).click();
						} 
						if (OpcExtremidad7.equals("SI")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[15]")).click();
						} else if (OpcExtremidad7.equals("NO")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[16]")).click();
						} 
						if (!OpcExtremidad8.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[11]")).sendKeys(OpcExtremidad8);
						}
						driver.findElement(OpcionExtremidades).click();
					}
					// Campos Piel
					String OpcPiel1 = getCellValueSString(e, 9, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcPiel2 = getCellValueSString(e, 10, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcPiel3 = getCellValueSString(e, 11, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcPiel4 = getCellValueSString(e, 12, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcPiel5 = getCellValueSString(e, 13, "ExamenFisico", "Historia Clinica Pediatria");
					if (OpcPiel1.equals("") && OpcPiel2.equals("") && OpcPiel3.equals("")
							&& OpcPiel4.equals("") && OpcPiel5.equals("")) {
						System.out.println("No se selecciono alguna opcion de Piel");
					} else {				
						driver.findElement(OpcionPiel).click();
						if (OpcPiel1.equals("Ausente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[1]")).click();
						} else if (OpcPiel1.equals("Presente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}
						if (OpcPiel2.equals("Ausente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[3]")).click();
						} else if (OpcPiel2.equals("Presente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[4]")).click();
						}
						if (OpcPiel3.equals("Ausente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[5]")).click();
						} else if (OpcPiel3.equals("Presente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[6]")).click();
						} 
						if (OpcPiel4.equals("Ausente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[7]")).click();
						} else if (OpcPiel4.equals("Presente")) {
							driver.findElement(By.xpath("(//div[@id='Piel']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[8]")).click();
						}
						if (!OpcPiel5.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[12]")).sendKeys(OpcPiel5);
						}
						driver.findElement(OpcionPiel).click();
					}
					// Campos Neurologico
					String OpcNeu1 = getCellValueSString(e, 14, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcNeu2 = getCellValueSString(e, 15, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcNeu3 = getCellValueSString(e, 16, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcNeu4 = getCellValueSString(e, 17, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcNeu5 = getCellValueSString(e, 18, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcNeu6 = getCellValueSString(e, 19, "ExamenFisico", "Historia Clinica Pediatria");
					if (OpcNeu1.equals("") && OpcNeu2.equals("") && OpcNeu3.equals("")
							&& OpcNeu4.equals("") && OpcNeu5.equals("")&& OpcNeu6.equals("")) {
						System.out.println("No se selecciono alguna opcion de Extremidades");
					} else {				
						driver.findElement(OpcionNeurologico).click();
						if (OpcNeu1.equals("Cognicion")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[1]")).click();
						} else if (OpcNeu1.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}else if (OpcNeu1.equals("Memorial")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}else if (OpcNeu1.equals("C�lculo")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}else if (OpcNeu1.equals("Orientac�on")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}
						if (OpcNeu2.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[3]")).click();
						} else if (OpcNeu2.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[4]")).click();
						}
						if (OpcNeu3.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[5]")).click();
						} else if (OpcNeu3.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[6]")).click();
						} 
						if (OpcNeu4.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[7]")).click();
						} else if (OpcNeu4.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[8]")).click();
						}
						if (OpcNeu5.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[9]")).click();
						} else if (OpcNeu5.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[10]")).click();
						}
						if (!OpcPiel5.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[12]")).sendKeys(OpcPiel5);
						}
						driver.findElement(OpcionNeurologico).click();
					}
					// Campos Ex�men Psiquiatrico
					String OpcEP1 = getCellValueSString(f, 1, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcEP2 = getCellValueSString(f, 2, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcEP3 = getCellValueSString(f, 3, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcEP4 = getCellValueSString(f, 4, "ExamenFisico", "Historia Clinica Pediatria");
					String OpcEP5 = getCellValueSString(f, 5, "ExamenFisico", "Historia Clinica Pediatria");
					if (OpcEP1.equals("") && OpcEP2.equals("") && OpcEP3.equals("")
							&& OpcEP4.equals("") && OpcEP5.equals("")) {
						System.out.println("No se selecciono alguna opcion de Ex�men Psiqui�trico");
					} else {				
						driver.findElement(OpcionEP).click();
						if (OpcEP1.equals("Normal ")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[1]")).click();
						} else if (OpcEP1.equals("Globuloso")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}else if (OpcEP1.equals("Excavado")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}
						if (OpcEP2.equals("Ausente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[3]")).click();
						} else if (OpcEP2.equals("Masas Der")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[4]")).click();
						}else if (OpcEP2.equals("Masas Izq")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[4]")).click();
						}
						if (OpcEP3.equals("ausente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[5]")).click();
						} else if (OpcEP3.equals("Hepatomegalia")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[6]")).click();
						} else if (OpcEP3.equals("Esplenomegalia")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[6]")).click();
						} 
						if (OpcEP4.equals("ausente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[7]")).click();
						} else if (OpcEP4.equals("Presente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[8]")).click();
						}						
						if (!OpcEP5.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[14]")).sendKeys(OpcEP5);
						}
						driver.findElement(OpcionEP).click();
					}	
	}

	public void ExamenFisicoMFisica(WebDriver driver, int a, int b, int c, int d, int e, int f,int g,int h) throws IOException, InterruptedException {
		String Sexo=driver.findElement(SexoPaciente).getText().strip();
		driver.findElement(OpcionExamenFisico).click();
		Thread.sleep(1000);
		// Inspecci�n General		
		String Opc1 = getCellValueSString(a, 1, "ExamenFisico","Historia Clinica Medicina Fisica");
		String Opc2 = getCellValueSString(a, 2, "ExamenFisico","Historia Clinica Medicina Fisica");
		String Opc3 = getCellValueSString(a, 3, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String Opc4 = getCellValueSString(a, 4, "ExamenFisico","Historia Clinica Medicina Fisica");
		String Opc5 = getCellValueSString(a, 5, "ExamenFisico","Historia Clinica Medicina Fisica");
		String Opc6 = getCellValueSString(a, 6, "ExamenFisico","Historia Clinica Medicina Fisica");
		
		if(Opc1.equals("")&&Opc2.equals("")&&Opc3.equals("")&&Opc4.equals("")&&Opc5.equals("")&&Opc6.equals("")) {
			System.out.println("No se selecciono alguna opcion de Inspeccion General");
		}else {
			if(Opc1.equals("Alerta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[1]")).click();
			}else if(Opc1.equals("Somnoliento")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[2]")).click();
			}else if(Opc1.equals("Estuporoso")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[3]")).click();
			}else if(Opc1.equals("Comatoso")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[4]")).click();
			}
			if(Opc2.equals("Ausente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[5]")).click();
			}else if(Opc2.equals("Leve")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[6]")).click();
			}else if(Opc2.equals("Moderada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[7]")).click();
			}else if(Opc2.equals("Severa")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[8]")).click();
			}
			if(Opc3.equals("Colaborador")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[9]")).click();
			}else if(Opc3.equals("Medianamente Colaborador")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[10]")).click();
			}else if(Opc3.equals("Algo colaborador")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[11]")).click();
			}else if(Opc3.equals("No Colabora con  EF")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[12]")).click();
			}
			if(Opc4.equals("Sin restric�on")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[13]")).click();
			}else if(Opc4.equals("Restricc�on Leve")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[14]")).click();
			}else if(Opc4.equals("Restricc�on Moderada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[15]")).click();
			}else if(Opc4.equals("Postrado")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[16]")).click();
			}
			if(Opc5.equals("Eutr�fico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[17]")).click();
			}else if(Opc5.equals("Obeso")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[18]")).click();
			}else if(Opc5.equals("Anor�xico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[19]")).click();
			}else if(Opc5.equals("Caqu�tico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[20]")).click();
			}
			if(!Opc6.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[1]")).sendKeys(Opc6);
			}
			driver.findElement(OpcionInspeccionGeneral).click();
		}
		
        //Campos Cabeza
		String OpcCabeza1 = getCellValueSString(a, 7, "ExamenFisico","Historia Clinica Medicina Fisica");
		String OpcCabeza2 = getCellValueSString(a, 8, "ExamenFisico","Historia Clinica Medicina Fisica");
		String OpcCabeza3 = getCellValueSString(a, 9, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcCabeza4 = getCellValueSString(a, 10, "ExamenFisico","Historia Clinica Medicina Fisica");
		String OpcCabeza5 = getCellValueSString(a, 11, "ExamenFisico","Historia Clinica Medicina Fisica");
		if(OpcCabeza1.equals("")&&OpcCabeza2.equals("")&&OpcCabeza3.equals("")&&OpcCabeza4.equals("")&&OpcCabeza5.equals("")) {
			System.out.println("No se selecciono alguna opcion de Cabeza");
		}else {
			driver.findElement(OpcionCabeza).click();
			if(OpcCabeza1.equals("Normocr�neo")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[21]")).click();
			}else if(OpcCabeza1.equals("Microcef�lico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[22]")).click();
			}else if(OpcCabeza1.equals("Macrocef�lico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[23]")).click();
			}else if(OpcCabeza1.equals("Plagiocefalico")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[24]")).click();
			}
			if(OpcCabeza2.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[25]")).click();
			}else if(OpcCabeza2.equals("Descamaci�n")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[26]")).click();
			}else if(OpcCabeza2.equals("alopecia aerata")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[27]")).click();
			}else if(OpcCabeza2.equals("Alopecia generalizada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[28]")).click();
			}
			if(OpcCabeza3.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[29]")).click();
			}else if(OpcCabeza3.equals("Asimetr�ca")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[30]")).click();
			}else if(OpcCabeza3.equals("Abotagada")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[31]")).click();
			}else if(OpcCabeza3.equals("Cushinoide")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[32]")).click();
			}
			if(OpcCabeza4.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[33]")).click();
			}else if(OpcCabeza4.equals("Protuberante")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[34]")).click();
			}
			if(!OpcCabeza5.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[2]")).sendKeys(OpcCabeza5);
			}
			driver.findElement(OpcionCabeza).click();
		}
		
		//Diligencionamiento Campos OJOS
		String OpcOjo1 = getCellValueSString(a, 12, "ExamenFisico","Historia Clinica Medicina Fisica");
		String OpcOjo2 = getCellValueSString(a, 13, "ExamenFisico","Historia Clinica Medicina Fisica");
		String OpcOjo3 = getCellValueSString(a, 14, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcOjo4 = getCellValueSString(a, 15, "ExamenFisico","Historia Clinica Medicina Fisica");
		String OpcOjo5 = getCellValueSString(a, 16, "ExamenFisico","Historia Clinica Medicina Fisica");
		String OpcOjo6 = getCellValueSString(a, 17, "ExamenFisico","Historia Clinica Medicina Fisica");
		if(OpcOjo1.equals("")&&OpcOjo2.equals("")&&OpcOjo3.equals("")&&OpcOjo4.equals("")&&OpcOjo5.equals("")&&OpcOjo6.equals("")) {
			System.out.println("No se selecciono alguna opcion de Cabeza");
		}else {
			driver.findElement(OpcionOjo).click();
			if(OpcOjo1.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[35]")).click();
			}else if(OpcOjo1.equals("Hipocromicas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[36]")).click();
			}else if(OpcOjo1.equals("Secreci�n Clara")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[37]")).click();
			}else if(OpcOjo1.equals("Sereci�n Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[38]")).click();
			}
			if(OpcOjo2.equals("Normales")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[39]")).click();
			}else if(OpcOjo2.equals("Ict�ricas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[40]")).click();
			}else if(OpcOjo2.equals("Pterigios")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[41]")).click();
			}else if(OpcOjo2.equals("Cuerpo ExtrAño")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[42]")).click();
			}
			if(OpcOjo3.equals("Isoc�ricas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[43]")).click();
			}else if(OpcOjo3.equals("Anisic�ricas")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[44]")).click();
			}
			if(OpcOjo4.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[45]")).click();
			}else if(OpcOjo4.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[46]")).click();
			}
			if(OpcOjo5.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[47]")).click();
			}else if(OpcOjo5.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[48]")).click();
			}
			if(!OpcOjo6.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[3]")).sendKeys(OpcOjo6);
			}
			driver.findElement(OpcionOjo).click();
		}
		
		// Diligencionamiento Campos Nar�z
		String OpcNariz1 = getCellValueSString(b, 1, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcNariz2 = getCellValueSString(b, 2, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcNariz3 = getCellValueSString(b, 3, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcNariz4 = getCellValueSString(b, 4, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcNariz5 = getCellValueSString(b, 5, "ExamenFisico", "Historia Clinica Medicina Fisica");
		if (OpcNariz1.equals("") && OpcNariz2.equals("") && OpcNariz3.equals("") && OpcNariz4.equals("") && OpcNariz5.equals("")) {
			System.out.println("No se selecciono alguna opcion de Nariz");
		} else {		
			driver.findElement(OpcionNariz).click();
			if (OpcNariz1.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[49]")).click();
			} else if (OpcNariz1.equals("Grande")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[50]")).click();
			} 
			if (OpcNariz2.equals("Ausente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[51]")).click();
			} else if (OpcNariz2.equals("Presente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[52]")).click();
			} 
			if (OpcNariz3.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[53]")).click();
			} else if (OpcNariz3.equals("P�lida")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[54]")).click();
			}else if (OpcNariz3.equals("Hiper�mica")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[55]")).click();
			}else if (OpcNariz3.equals("Cornetes  Hipertr�ficos")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[56]")).click();
			}
			if (OpcNariz4.equals("Ausente")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[57]")).click();
			} else if (OpcNariz4.equals("Mucoide")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[58]")).click();
			}else if (OpcNariz4.equals("Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[59]")).click();
			}else if (OpcNariz4.equals("Epistaxis")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[60]")).click();
			}			
			if (!OpcNariz5.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[3]")).sendKeys(OpcNariz5);
			}
			driver.findElement(OpcionNariz).click();
		}
		
		//  Campos O�dos
		String OpcOidos1 = getCellValueSString(b, 6, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcOidos2 = getCellValueSString(b, 7, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcOidos3 = getCellValueSString(b, 8, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcOidos4 = getCellValueSString(b, 9, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcOidos5 = getCellValueSString(b, 10, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcOidos6 = getCellValueSString(b, 11, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcOidos7 = getCellValueSString(b, 12, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcOidos8 = getCellValueSString(b, 13, "ExamenFisico", "Historia Clinica Medicina Fisica");
		String OpcOidos9 = getCellValueSString(b, 14, "ExamenFisico", "Historia Clinica Medicina Fisica");
		if (OpcOidos1.equals("") && OpcOidos2.equals("") && OpcOidos3.equals("") && OpcOidos4.equals("")
				&& OpcOidos5.equals("") && OpcOidos6.equals("") && OpcOidos7.equals("") && OpcOidos8.equals("")
				&& OpcOidos9.equals("")) {
			System.out.println("No se selecciono alguna opcion de O�do");
		} else {			
			driver.findElement(OpcionOidos).click();
			if (OpcOidos1.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[61]")).click();
			} else if (OpcOidos1.equals("Secreci�n Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[62]")).click();
			} else if (OpcOidos1.equals("Cuerpo ExtrAño")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[63]")).click();
			} else if (OpcOidos1.equals("Tap�n de Cerumen")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[64]")).click();
			} 
			if (OpcOidos2.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[65]")).click();
			} else if (OpcOidos2.equals("Secreci�n Purulenta")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[66]")).click();
			}  else if (OpcOidos2.equals("Cuerpo ExtrAño")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[67]")).click();
			} else if (OpcOidos2.equals("Tap�n de Cerumen")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[68]")).click();
			} 
			if (OpcOidos3.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[69]")).click();
			} else if (OpcOidos3.equals("Opacidad")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[70]")).click();
			}else if (OpcOidos3.equals("Perforacion")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[71]")).click();
			}
			if (OpcOidos4.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[72]")).click();
			} else if (OpcOidos4.equals("Opacidad")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[73]")).click();
			}else if (OpcOidos4.equals("Perforacion")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[74]")).click();
			}	
			if (OpcOidos5.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[75]")).click();
			} else if (OpcOidos5.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[76]")).click();
			}
			if (OpcOidos6.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[77]")).click();
			} else if (OpcOidos6.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[78]")).click();
			}if (OpcOidos7.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[79]")).click();
			} else if (OpcOidos7.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[80]")).click();
			}
			if (OpcOidos8.equals("Normal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[81]")).click();
			} else if (OpcOidos8.equals("Anormal")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[82]")).click();
			}
			if (!OpcOidos9.equals("")) {
				driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[4]")).sendKeys(OpcOidos9);
			}
			driver.findElement(OpcionOidos).click();
		}
		
	//  Campos Boca
			String OpcBoca1 = getCellValueSString(c, 1, "ExamenFisico", "Historia Clinica Medicina Fisica");
			String OpcBoca2 = getCellValueSString(c, 2, "ExamenFisico", "Historia Clinica Medicina Fisica");
			String OpcBoca3 = getCellValueSString(c, 3, "ExamenFisico", "Historia Clinica Medicina Fisica");
			String OpcBoca4 = getCellValueSString(c, 4, "ExamenFisico", "Historia Clinica Medicina Fisica");
			String OpcBoca5 = getCellValueSString(c, 5, "ExamenFisico", "Historia Clinica Medicina Fisica");
			String OpcBoca6 = getCellValueSString(c, 6, "ExamenFisico", "Historia Clinica Medicina Fisica");
			String OpcBoca7 = getCellValueSString(c, 7, "ExamenFisico", "Historia Clinica Medicina Fisica");
			String OpcBoca8 = getCellValueSString(c, 8, "ExamenFisico", "Historia Clinica Medicina Fisica");
			if (OpcBoca1.equals("") && OpcBoca2.equals("") && OpcBoca3.equals("") && OpcBoca4.equals("")
					&& OpcBoca5.equals("") && OpcBoca6.equals("") && OpcBoca7.equals("")&& OpcBoca8.equals("")) {
				System.out.println("No se selecciono alguna opcion de Boca");
			} else {				
				driver.findElement(OpcionBocaEF).click();
				if (OpcBoca1.equals("Normales")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[83]")).click();
				} else if (OpcBoca1.equals("Hendidura superior")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[84]")).click();
				} else if (OpcBoca1.equals("Fisurados")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[85]")).click();
				} else if (OpcBoca1.equals("Ves�culas y costras")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[86]")).click();
				} 
				if (OpcBoca2.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[87]")).click();
				} else if (OpcBoca2.equals("Alto")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[88]")).click();
				} else if (OpcBoca2.equals("Fisurado")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[89]")).click();
				} else if (OpcBoca2.equals("Hendido")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[90]")).click();
				} 
				if (OpcBoca3.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[91]")).click();
				} else if (OpcBoca3.equals("Geogr�fica")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[92]")).click();
				} else if (OpcBoca3.equals("Fisurada")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[93]")).click();
				} else if (OpcBoca3.equals("Con frenillo sublingual")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[94]")).click();
				} 
				if (OpcBoca4.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[95]")).click();
				} else if (OpcBoca4.equals("Caries")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[96]")).click();
				} else if (OpcBoca4.equals("Anodoncia")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[97]")).click();
				} else if (OpcBoca4.equals("Abceso")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[98]")).click();
				} 
				if (OpcBoca5.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[99]")).click();
				} else if (OpcBoca5.equals("Hipertr�ficas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[100]")).click();
				} else if (OpcBoca5.equals("Hiper�micas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[101]")).click();
				} else if (OpcBoca5.equals("Purulentas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[102]")).click();
				} 
				if (OpcBoca6.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[103]")).click();
				} else if (OpcBoca6.equals("Hiper�micas")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[104]")).click();
				} else if (OpcBoca6.equals("Vesicular")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[105]")).click();
				}
				if (OpcBoca7.equals("Normal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[106]")).click();
				} else if (OpcBoca7.equals("Anormal")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[107]")).click();
				}
				if (!OpcBoca8.equals("")) {
					driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[5]")).sendKeys(OpcBoca8);
				}
				driver.findElement(OpcionBocaEF).click();
			}
			
				//  Campos Cuello
					String OpcCuello1 = getCellValueSString(c, 9, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcCuello2 = getCellValueSString(c, 10, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcCuello3 = getCellValueSString(c, 11, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcCuello4 = getCellValueSString(c, 12, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcCuello5 = getCellValueSString(c, 13, "ExamenFisico", "Historia Clinica Medicina Fisica");
					if (OpcCuello1.equals("") && OpcCuello2.equals("") && OpcCuello3.equals("") && OpcCuello4.equals("")
							&& OpcCuello5.equals("")) {
						System.out.println("No se selecciono alguna opcion de Cuello");
					} else {					
						driver.findElement(OpcionCuello).click();
						if (OpcCuello1.equals("Normales")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[108]")).click();
						} else if (OpcCuello1.equals("Limitac�on de la movilidad Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[109]")).click();
						} else if (OpcCuello1.equals("Limitac�on de la movilidad Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[110]")).click();
						} else if (OpcCuello1.equals("Espasmo cervical Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[111]")).click();
						} else if (OpcCuello1.equals("Espasmo cervical Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[112]")).click();
						} 
						if (OpcCuello2.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[113]")).click();
						} else if (OpcCuello2.equals("Tiromegalia Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[114]")).click();
						} else if (OpcCuello2.equals("Tiromegalia Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[115]")).click();
						} else if (OpcCuello2.equals("N�dulo palpable Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[116]")).click();
						} else if (OpcCuello2.equals("N�dulo palpable Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[117]")).click();
						} 
						if (OpcCuello3.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[118]")).click();
						} else if (OpcCuello3.equals("Desviac�on  de la tr�quea Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[119]")).click();
						} else if (OpcCuello3.equals("Desviac�on  de la tr�quea Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[120]")).click();
						} else if (OpcCuello3.equals("Ingurgitac�on Yugular G1")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[121]")).click();
						} else if (OpcCuello3.equals("Ingurgitac�on Yugular G2")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[122]")).click();
						} else if (OpcCuello3.equals("Ingurgitac�on Yugular G3")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[123]")).click();
						} 
						if (OpcCuello4.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[124]")).click();
						} else if (OpcCuello4.equals("Cervical anterior Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[125]")).click();
						} else if (OpcCuello4.equals("Cervical anterior Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[126]")).click();
						} else if (OpcCuello4.equals("Cervical posterior Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[127]")).click();
						} else if (OpcCuello4.equals("Cervical posterior Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[128]")).click();
						}
						if (!OpcCuello5.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[6]")).sendKeys(OpcCuello5);
						}
						driver.findElement(OpcionCuello).click();
					}
				//  Campos Torax
					String OpcTorax1 = getCellValueSString(c, 14, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcTorax2 = getCellValueSString(c, 15, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcTorax3 = getCellValueSString(c, 16, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcTorax4 = getCellValueSString(c, 17, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcTorax5 = getCellValueSString(c, 18, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcTorax6 = getCellValueSString(c, 19, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcTorax7 = getCellValueSString(c, 20, "ExamenFisico", "Historia Clinica Medicina Fisica");
					if (OpcTorax1.equals("") && OpcTorax2.equals("") && OpcTorax3.equals("") && OpcTorax4.equals("")
							&& OpcTorax5.equals("")&& OpcTorax6.equals("")&& OpcTorax7.equals("")) {
						System.out.println("No se selecciono alguna opcion de Torax");
					} else {					
						driver.findElement(OpcionTorax).click();
						if (OpcTorax1.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[129]")).click();
						} else if (OpcTorax1.equals("Anormal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[130]")).click();
						} 
						if (OpcTorax2.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[131]")).click();
						} else if (OpcTorax2.equals("Anormal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[132]")).click();
						} 
						if (OpcTorax3.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[133]")).click();
						} else if (OpcTorax3.equals("Anormal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[134]")).click();
						} 
						if (OpcTorax4.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[135]")).click();
						} else if (OpcTorax4.equals("N�dulo Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[136]")).click();
						} else if (OpcTorax4.equals("N�dulo Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[137]")).click();
						} 
						if (OpcTorax5.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[138]")).click();
						} else if (OpcTorax5.equals("Ganglios")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[139]")).click();
						}
						if (OpcTorax6.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[140]")).click();
						} else if (OpcTorax6.equals("Ganglios")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[141]")).click();
						}
						if (!OpcTorax7.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[7]")).sendKeys(OpcTorax7);
						}
						driver.findElement(OpcionTorax).click();
					}
				//  Campos abdomen
					String OpcAbdomen1 = getCellValueSString(d, 1, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcAbdomen2 = getCellValueSString(d, 2, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcAbdomen3 = getCellValueSString(d, 3, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcAbdomen4 = getCellValueSString(d, 4, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcAbdomen5 = getCellValueSString(d, 5, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcAbdomen6 = getCellValueSString(d, 6, "ExamenFisico", "Historia Clinica Medicina Fisica");
					if (OpcAbdomen1.equals("") && OpcAbdomen2.equals("") && OpcAbdomen3.equals("") && OpcAbdomen4.equals("")
							&& OpcAbdomen5.equals("")&& OpcAbdomen6.equals("")) {
						System.out.println("No se selecciono alguna opcion de Abdomen");
					} else {					
						driver.findElement(OpcionAbdomen).click();
						if (OpcAbdomen1.equals("Normal")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[142]")).click();
						} else if (OpcAbdomen1.equals("Globuloso")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[143]")).click();
						} else if (OpcAbdomen1.equals("Excavado")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[144]")).click();
						} 
						if (OpcAbdomen2.equals("Ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[145]")).click();
						} else if (OpcAbdomen2.equals("Masas Der")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[146]")).click();
						} else if (OpcAbdomen2.equals("Masas Izq")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[147]")).click();
						} 
						if (OpcAbdomen3.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[148]")).click();
						} else if (OpcAbdomen3.equals("Hepatomegalia")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[149]")).click();
						} else if (OpcAbdomen3.equals("Esplenomegalia")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[150]")).click();
						} 
						if (OpcAbdomen4.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[151]")).click();
						} else if (OpcAbdomen4.equals("ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[152]")).click();
						} 
						if (OpcAbdomen5.equals("Ausente")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[153]")).click();
						} else if (OpcAbdomen5.equals("Leve")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[154]")).click();
						}else if (OpcTorax5.equals("A tensi�n")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[155]")).click();
						}						
						if (!OpcAbdomen6.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[9]")).sendKeys(OpcAbdomen6);
						}
						driver.findElement(OpcionAbdomen).click();
					}
				//  Campos Genitales
					if(Sexo.equals("Femenino")) {
					
						String OpcGenitales1 = getCellValueSString(d, 11, "ExamenFisico", "Historia Clinica Medicina Fisica");
						String OpcGenitales2 = getCellValueSString(d, 12, "ExamenFisico", "Historia Clinica Medicina Fisica");
						String OpcGenitales3 = getCellValueSString(d, 13, "ExamenFisico", "Historia Clinica Medicina Fisica");
						String OpcGenitales4 = getCellValueSString(d, 14, "ExamenFisico", "Historia Clinica Medicina Fisica");
						String OpcGenitales5 = getCellValueSString(d, 15, "ExamenFisico", "Historia Clinica Medicina Fisica");
						if (OpcGenitales1.equals("") && OpcGenitales2.equals("") && OpcGenitales3.equals("") && OpcGenitales4.equals("")
								&& OpcGenitales5.equals("")) {
							System.out.println("No se selecciono alguna opcion de Genitales Femenino");
						} else {					
							driver.findElement(OpcionGenitalesF).click();
							if (OpcAbdomen1.equals("I")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[156]")).click();
							} else if (OpcGenitales1.equals("II")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[157]")).click();
							} else if (OpcGenitales1.equals("III")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[158]")).click();
							} else if (OpcGenitales1.equals("IV")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[159]")).click();
							} else if (OpcGenitales1.equals("V")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[160]")).click();
							} 
							if (OpcGenitales2.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[161]")).click();
							} else if (OpcGenitales2.equals("Masas Der")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[162]")).click();
							} else if (OpcGenitales2.equals("Masas Izq")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[163]")).click();
							} 
							if (OpcGenitales3.equals("Normales")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[164]")).click();
							} else if (OpcGenitales3.equals("Dolor al Movilizar el c�rvix")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[165]")).click();
							} else if (OpcGenitales3.equals("Masa en cerv�x")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[166]")).click();
							} 
							if (OpcGenitales4.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[167]")).click();
							} else if (OpcGenitales4.equals("Prolapso")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[168]")).click();
							} 											
							if (!OpcGenitales5.equals("")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[10]")).sendKeys(OpcGenitales5);
							}
							driver.findElement(OpcionGenitalesF).click();
						}
					}else if(Sexo.equals("Masculino")) {
						String OpcGenitales1 = getCellValueSString(d, 11, "ExamenFisico", "Historia Clinica Medicina Fisica");
						String OpcGenitales2 = getCellValueSString(d, 12, "ExamenFisico", "Historia Clinica Medicina Fisica");
						String OpcGenitales3 = getCellValueSString(d, 13, "ExamenFisico", "Historia Clinica Medicina Fisica");
						String OpcGenitales4 = getCellValueSString(d, 14, "ExamenFisico", "Historia Clinica Medicina Fisica");
						if (OpcGenitales1.equals("") && OpcGenitales2.equals("") && OpcGenitales3.equals("") && OpcGenitales4.equals("")) {
							System.out.println("No se selecciono alguna opcion de Genitales Masculino");
						} else {					
							driver.findElement(OpcionGenitalesM).click();
							if (OpcAbdomen1.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[156]")).click();
							} else if (OpcGenitales1.equals("Masa Der")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[157]")).click();
							} else if (OpcGenitales1.equals("Masa Izq")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[158]")).click();
							} 
							if (OpcGenitales2.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[159]")).click();
							} else if (OpcGenitales2.equals("Anormal Der")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[160]")).click();
							} else if (OpcGenitales2.equals("anormal Izq")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[161]")).click();
							} 
							if (OpcGenitales3.equals("Normal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[162]")).click();
							} else if (OpcGenitales3.equals("Eritema")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[163]")).click();
							} else if (OpcGenitales3.equals("Secrec�on uretal")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[164]")).click();
							} 									
							if (!OpcGenitales4.equals("")) {
								driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[10]")).sendKeys(OpcGenitales4);
							}
							driver.findElement(OpcionGenitalesM).click();
						}
					}
					// Campos Extremidades
					String OpcExtremidad1 = getCellValueSString(e, 1, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcExtremidad2 = getCellValueSString(e, 2, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcExtremidad3 = getCellValueSString(e, 3, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcExtremidad4 = getCellValueSString(e, 4, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcExtremidad5 = getCellValueSString(e, 5, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcExtremidad6 = getCellValueSString(e, 6, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcExtremidad7 = getCellValueSString(e, 7, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcExtremidad8 = getCellValueSString(e, 8, "ExamenFisico", "Historia Clinica Medicina Fisica");
					if (OpcExtremidad1.equals("") && OpcExtremidad2.equals("") && OpcExtremidad3.equals("")
							&& OpcExtremidad4.equals("") && OpcExtremidad5.equals("") && OpcExtremidad6.equals("")
							&& OpcExtremidad7.equals("") && OpcExtremidad8.equals("")) {
						System.out.println("No se selecciono alguna opcion de Extremidades");
					} else {				
						driver.findElement(OpcionExtremidades).click();
						if (OpcExtremidad1.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[1]")).click();
						} else if (OpcExtremidad1.equals("Hipotrofia leve")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[2]")).click();
						} else if (OpcExtremidad1.equals("Hipotrofia moderada")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[3]")).click();
						} else if (OpcExtremidad1.equals("Hipotrofia severa")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[4]")).click();
						} 
						if (OpcExtremidad2.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[5]")).click();
						} else if (OpcExtremidad2.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[6]")).click();
						} 
						if (OpcExtremidad3.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[7]")).click();
						} else if (OpcExtremidad3.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[8]")).click();
						} 
						if (OpcExtremidad4.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[9]")).click();
						} else if (OpcExtremidad4.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[10]")).click();
						} 
						if (OpcExtremidad5.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[11]")).click();
						} else if (OpcExtremidad5.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[12]")).click();
						} 
						if (OpcExtremidad6.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[13]")).click();
						} else if (OpcExtremidad6.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[14]")).click();
						} 
						if (OpcExtremidad7.equals("SI")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[15]")).click();
						} else if (OpcExtremidad7.equals("NO")) {
							driver.findElement(By.xpath("(//div[@id='Extremidades']//../div[@class='dx-checkbox-container']/span[@class='dx-checkbox-icon'])[16]")).click();
						} 
						if (!OpcExtremidad8.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[11]")).sendKeys(OpcExtremidad8);
						}
						driver.findElement(OpcionExtremidades).click();
					}					
					// Campos Neurologico
					String OpcNeu1 = getCellValueSString(e, 14, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcNeu2 = getCellValueSString(e, 15, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcNeu3 = getCellValueSString(e, 16, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcNeu4 = getCellValueSString(e, 17, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcNeu5 = getCellValueSString(e, 18, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcNeu6 = getCellValueSString(e, 19, "ExamenFisico", "Historia Clinica Medicina Fisica");
					if (OpcNeu1.equals("") && OpcNeu2.equals("") && OpcNeu3.equals("")
							&& OpcNeu4.equals("") && OpcNeu5.equals("")&& OpcNeu6.equals("")) {
						System.out.println("No se selecciono alguna opcion de Extremidades");
					} else {				
						driver.findElement(OpcionNeurologico).click();
						if (OpcNeu1.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[1]")).click();
						} else if (OpcNeu1.equals("Memorial")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}else if (OpcNeu1.equals("C�lculo")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[3]")).click();
						}else if (OpcNeu1.equals("Orientac�on")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[4]")).click();
						}
						if (OpcNeu2.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[5]")).click();
						} else if (OpcNeu2.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[6]")).click();
						}
						if (OpcNeu3.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[7]")).click();
						} else if (OpcNeu3.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[8]")).click();
						} 
						if (OpcNeu4.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[9]")).click();
						} else if (OpcNeu4.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[10]")).click();
						}
						if (OpcNeu5.equals("Normal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[11]")).click();
						} else if (OpcNeu5.equals("Anormal")) {
							driver.findElement(By.xpath("(//div[@id='Neurol�gico ']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[12]")).click();
						}
						if (!OpcNeu6.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[12]")).sendKeys(OpcNeu6);
						}
						driver.findElement(OpcionNeurologico).click();
					}
					// Campos Ex�men Psiquiatrico
					String OpcEP1 = getCellValueSString(f, 1, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcEP2 = getCellValueSString(f, 2, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcEP3 = getCellValueSString(f, 3, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcEP4 = getCellValueSString(f, 4, "ExamenFisico", "Historia Clinica Medicina Fisica");
					String OpcEP5 = getCellValueSString(f, 5, "ExamenFisico", "Historia Clinica Medicina Fisica");
					if (OpcEP1.equals("") && OpcEP2.equals("") && OpcEP3.equals("")
							&& OpcEP4.equals("") && OpcEP5.equals("")) {
						System.out.println("No se selecciono alguna opcion de Ex�men Psiqui�trico");
					} else {				
						driver.findElement(OpcionEP).click();
						if (OpcEP1.equals("Normal ")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[1]")).click();
						} else if (OpcEP1.equals("Globuloso")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}else if (OpcEP1.equals("Excavado")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[2]")).click();
						}
						if (OpcEP2.equals("Ausente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[3]")).click();
						} else if (OpcEP2.equals("Masas Der")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[4]")).click();
						}else if (OpcEP2.equals("Masas Izq")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[4]")).click();
						}
						if (OpcEP3.equals("ausente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[5]")).click();
						} else if (OpcEP3.equals("Hepatomegalia")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[6]")).click();
						} else if (OpcEP3.equals("Esplenomegalia")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[6]")).click();
						} 
						if (OpcEP4.equals("ausente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[7]")).click();
						} else if (OpcEP4.equals("Presente")) {
							driver.findElement(By.xpath("(//div[@id='Ex�men psiqui�trico']//../div/div/div/dx-check-box/div/span[@class='dx-checkbox-icon'])[8]")).click();
						}						
						if (!OpcEP5.equals("")) {
							driver.findElement(By.xpath("((//*[@class='physical-content ng-star-inserted'])[1]//../div/input)[13]")).sendKeys(OpcEP5);
						}
						driver.findElement(OpcionEP).click();
					}	
	}
	
	public void CrecimientoDesarrolloPediatria(WebDriver driver,int a, int b, int c) throws InterruptedException, IOException {
		driver.findElement(OpcionCrecimientoDesarrollo).click();
		Thread.sleep(500);
		//Patrones de Crecimiento Infantil
		String Peso=""+getCellValuesInt(a, 1, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Talla=""+getCellValuesInt(a, 2, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Cintura=""+getCellValuesInt(a, 3, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Craneo=""+getCellValuesInt(a, 4, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		if(Peso.equals("") && Talla.equals("") && Cintura.equals("") && Craneo.equals("")) {
			System.out.print("No se Diligenciaron datos en Patrones de Crecimiento Infantil ");
		}else {
			if(!Peso.equals("")&&!Peso.equals("0")) {
				driver.findElement(PesoLocator).click();
				driver.findElement(PesoLocator).clear();
				driver.findElement(PesoLocator).sendKeys(Peso);
			}
			if(!Talla.equals("")&&!Talla.equals("0")) {
				driver.findElement(TallaLocatorcm).click();
				driver.findElement(TallaLocatorcm).clear();
				driver.findElement(TallaLocatorcm).sendKeys(Talla);
			}
			if(!Cintura.equals("")&&!Cintura.equals("0")) {
				driver.findElement(CinturaLocator).click();
				driver.findElement(CinturaLocator).clear();
				driver.findElement(CinturaLocator).sendKeys(Cintura);
			}
			if(!Craneo.equals("")&&!Craneo.equals("0")) {
				driver.findElement(CraneanaLocator).click();
				driver.findElement(CraneanaLocator).clear();
				driver.findElement(CraneanaLocator).sendKeys(Craneo);
			}
		}
		Thread.sleep(500);
		//Valoracion de Signos de Maltratos
		String Valora1=getCellValueSString(a, 5, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Valora2=getCellValueSString(a, 6, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Valora3=getCellValueSString(a, 7, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Valora4=getCellValueSString(a, 8, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Valora5=getCellValueSString(a, 9, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		if(Valora1.equals("") && Valora2.equals("") && Valora3.equals("") && Valora4.equals("")&& Valora5.equals("")) {
			System.out.print("No se Diligenciaron datos en Valoracion de Signos de Maltratos");
		}else {
			if(Valora1.equals("SI")) {
				driver.findElement(Valoracion1Locator).click();
			}
			if(Valora2.equals("SI")) {
				driver.findElement(Valoracion2Locator).click();
			}
			if(Valora3.equals("SI")) {
				driver.findElement(Valoracion3Locator).click();
			}
			if(Valora4.equals("SI")) {
				driver.findElement(Valoracion4Locator).click();
			}
			if(!Valora5.equals("")) {
				driver.findElement(Valoracion5Locator).click();
				driver.findElement(Valoracion5Locator).sendKeys(Valora5);
			}
		}
		//Observaciones Generales
		String Obs1=getCellValueSString(b, 1, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Obs2=getCellValueSString(b, 2, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Obs3=getCellValueSString(b, 3, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Obs4=getCellValueSString(b, 4, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Obs5=getCellValueSString(b, 5, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Obs6=getCellValueSString(b, 6, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Obs7=getCellValueSString(b, 7, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Obs8=getCellValueSString(b, 8, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Obs9=getCellValueSString(b, 9, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		if (Obs1.equals("") && Obs2.equals("") && Obs3.equals("") && Obs4.equals("") && Obs5.equals("")
				&& Obs6.equals("") && Obs7.equals("") && Obs8.equals("") && Obs9.equals("")) {
			System.out.print("No se Diligenciaron datos en Valoracion de Observaciones Generales");
		}else {
			WebElement element = driver.findElement(By.xpath("((//*[@class='dx-accordion-wrapper'])//../div[@class='dx-item-content dx-accordion-item-title'])[12]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500);
			WebElement element1 = driver.findElement(By.xpath("((//div[@class='dx-layout-manager dx-widget'])/..//div[@class='dx-button-content'])[7]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(5000);
			
			if(Obs1.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[404]")).click();
			}else if(Obs1.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[405]")).click();
			}
			if(Obs2.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[406]")).click();
			}else if(Obs2.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[407]")).click();
			}
			if(Obs3.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[408]")).click();
			}else if(Obs3.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[409]")).click();
			}
			if(Obs4.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[410]")).click();
			}else if(Obs4.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[411]")).click();
			}
			if(Obs5.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[412]")).click();
			}else if(Obs5.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[413]")).click();
			}
			if(Obs6.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[414]")).click();
			}else if(Obs6.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[415]")).click();
			}
			if(Obs7.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[416]")).click();
			}else if(Obs7.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[417]")).click();
			}
			if(Obs8.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[418]")).click();
			}else if(Obs8.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[419]")).click();
			}
			if(Obs9.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[420]")).click();
			}else if(Obs9.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[421]")).click();
			}
		}
		//Seguimiento de ASQ
		String Seg1=""+getCellValuesInt(b, 10, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Seg2=getCellValueSString(b, 11, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Seg3=getCellValueSString(b, 12, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Seg4=getCellValueSString(b, 13, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Seg5=getCellValueSString(b, 14, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Seg6=getCellValueSString(b, 14, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Seg7=getCellValueSString(b, 16, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		if (Seg1.equals("") && Seg2.equals("") && Seg3.equals("") && Seg4.equals("") && Seg5.equals("")
				&& Seg6.equals("") && Seg7.equals("") ) {
			System.out.print("No se Diligenciaron datos en Valoracion en Seguimiento de ASQ");
		}else {
			WebElement element1 = driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[421]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(500);
			if(!Seg1.equals("")&&!Seg1.equals("0")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-checkbox-container'])[258]")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-texteditor-input-container']/input)[144]")).sendKeys(Seg1);
			}
			if(Seg2.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-checkbox-container'])[259]")).click();
			}
			if(Seg3.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-checkbox-container'])[260]")).click();
			}
			if(Seg4.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-checkbox-container'])[261]")).click();
			}
			if(Seg5.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-checkbox-container'])[262]")).click();
			}
			if(Seg6.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-checkbox-container'])[263]")).click();
			}
			if(Seg7.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-checkbox-container'])[264]")).click();
			}
		}
		//Valoraci�n de Autismo		
		String Val1=getCellValueSString(c, 1, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val2=getCellValueSString(c, 2, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val3=getCellValueSString(c, 3, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val4=getCellValueSString(c, 4, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val5=getCellValueSString(c, 5, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val6=getCellValueSString(c, 6, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val7=getCellValueSString(c, 7, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val8=getCellValueSString(c, 8, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val9=getCellValueSString(c, 9, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val10=getCellValueSString(c, 10, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val11=getCellValueSString(c, 11, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val12=getCellValueSString(c, 12, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val13=getCellValueSString(c, 13, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val14=getCellValueSString(c, 14, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val15=getCellValueSString(c, 15, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val16=getCellValueSString(c, 16, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val17=getCellValueSString(c, 17, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val18=getCellValueSString(c, 18, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val19=getCellValueSString(c, 19, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val20=getCellValueSString(c, 20, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val21=getCellValueSString(c, 21, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val22=getCellValueSString(c, 22, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		String Val23=getCellValueSString(c, 23, "CrecimientoDesarrollo","Historia Clinica Pediatria");
		if (Val1.equals("") && Val2.equals("") && Val3.equals("") && Val4.equals("") && Val5.equals("")
				&& Val6.equals("") && Val7.equals("") && Val8.equals("") && Val9.equals("") && Val10.equals("")
				&& Val11.equals("") && Val12.equals("") && Val13.equals("")&&Val14.equals("") && Val15.equals("") 
				&& Val16.equals("") && Val17.equals("") && Val18.equals("")&&Val19.equals("") && Val20.equals("") 
				&& Val21.equals("") && Val22.equals("") && Val23.equals("")) {
			System.out.print("No se Diligenciaron datos en Valoracion en Valoraci�n de Autismo");
		} else {
			WebElement element = driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-checkbox-container'])[264]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500);
			if(Val1.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[422]")).click();
			}else if(Val1.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[423]")).click();
			}
			if(Val2.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[424]")).click();
			}else if(Val2.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[425]")).click();
			}
			if(Val3.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[426]")).click();
			}else if(Val3.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[427]")).click();
			}
			if(Val4.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[428]")).click();
			}else if(Val4.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[429]")).click();
			}
			if(Val5.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[430]")).click();
			}else if(Val5.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[431]")).click();
			}
			if(Val6.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[432]")).click();
			}else if(Val6.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[433]")).click();
			}
			if(Val7.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[434]")).click();
			}else if(Val7.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[435]")).click();
			}
			WebElement element1 = driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[435]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(500);
			if(Val8.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[436]")).click();
			}else if(Val8.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[437]")).click();
			}
			if(Val9.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[438]")).click();
			}else if(Val9.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[439]")).click();
			}
			if(Val10.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[440]")).click();
			}else if(Val10.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[441]")).click();
			}
			if(Val11.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[442]")).click();
			}else if(Val11.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[443]")).click();
			}
			if(Val12.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[444]")).click();
			}else if(Val12.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[445]")).click();
			}
			if(Val13.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[446]")).click();
			}else if(Val13.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[447]")).click();
			}
			WebElement element2 = driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[447]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
			Thread.sleep(500);
			if(Val14.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[448]")).click();
			}else if(Val14.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[449]")).click();
			}
			if(Val15.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[450]")).click();
			}else if(Val15.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[451]")).click();
			}
			if(Val16.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[452]")).click();
			}else if(Val16.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[453]")).click();
			}
			if(Val17.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[454]")).click();
			}else if(Val17.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[455]")).click();
			}
			if(Val18.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[456]")).click();
			}else if(Val18.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[457]")).click();
			}
			WebElement element3 = driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[457]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
			Thread.sleep(500);
			if(Val19.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[458]")).click();
			}else if(Val19.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[459]")).click();
			}
			if(Val20.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[460]")).click();
			}else if(Val20.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[461]")).click();
			}
			if(Val21.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[462]")).click();
			}else if(Val21.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[463]")).click();
			}
			if(Val22.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[464]")).click();
			}else if(Val22.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[465]")).click();
			}
			if(Val23.equals("SI")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[466]")).click();
			}else if(Val23.equals("NO")) {
				driver.findElement(By.xpath("((//div[@class='dx-accordion-wrapper'])/..//div[@class='dx-radio-value-container'])[467]")).click();
			}
		}
	}
		
	/*public void AntecedentesGinecoObstetricos(WebDriver driver, int a) throws InterruptedException, IOException {
		// Ingreso_al_formulario_"Antecedentes_Ginecobstr�ticos"		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(SelectFormularioAntecedGineco).click();
		Thread.sleep(2000);
		String Sexo = driver.findElement(SexoPaciente).getText().strip();
		Thread.sleep(2000);
		String Edad = driver.findElement(DatoEdad).getText().strip();
		int Edades = 9;
		Boolean ResEdad = true;
		Boolean R = true;
		System.out.println(Edad);
		String EdadA = Edad.split(" ")[0];
		Integer.parseInt(EdadA.trim());
		System.out.println(EdadA);
		// Valida Paciente Mujer menosr de 9 Años
		if (ResEdad = ((Value.convertTextToNumber(EdadA)) < Edades) && (Sexo.equals("Femenino"))) {
			System.out.println("Paciente no tiene la edad minima para ginecoobstetricia");
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			//driver.findElement(clickCloseWindows).click();
			//Thread.sleep(1000);
			//driver.findElement(clickCloseWindowsComfirm).click();
			//Thread.sleep(2000);
			//driver.quit();
		} 	
		String Estado = getCellValueSString(a, 1, "AntecedenteGinecob","Historia Clinica Medicina de Urgencia");
		String EdadM =""+ getCellValuesInt(a, 2, "AntecedenteGinecob","Historia Clinica Medicina de Urgencia");
		String FUR =getCellValueSString(a, 3, "AntecedenteGinecob","Historia Clinica Medicina de Urgencia");
		
		//empleo@parameta.co
		//QA ANALYST
		// Sigue diligenciamiento Antecedentes Ginecoobstreticos
		// TMenarquia
		if (FUR.indexOf("-") != -1) {
			FUR = FUR.replace("-", "/");
		}
		if(Estado.equals("SI")) {
			driver.findElement(SelectBtnMenarquia).click();
			Thread.sleep(500);
			driver.findElement(SelectBtnEdadMenarquia).click();
			driver.findElement(SelectBtnEdadMenarquia).clear();
			driver.findElement(SelectBtnEdadMenarquia).sendKeys(EdadM);
			Thread.sleep(1000);
			// FechaFUR
			driver.findElement(SelectBoxFechaFUR).click();
			driver.findElement(SelectBoxFechaFUR).clear();
			driver.findElement(SelectBoxFechaFUR).sendKeys(FUR);
			Thread.sleep(1000);
		}
			
		String EstadoAnticoncepcion = getCellValueSString(a, 4, "AntecedenteGinecob","Historia Clinica Medicina de Urgencia");
		String MetodoAnti =getCellValueSString(a, 5, "AntecedenteGinecob","Historia Clinica Medicina de Urgencia");
		String FechaInicio =getCellValueSString(a, 6, "AntecedenteGinecob","Historia Clinica Medicina de Urgencia");
		String FechaFin =getCellValueSString(a, 7, "AntecedenteGinecob","Historia Clinica Medicina de Urgencia");
		if(EstadoAnticoncepcion.equals("SI")) {
		// UAnticoncepcion
		driver.findElement(SelectBtnAnticoncepcion).click();
		Thread.sleep(1000);
		WebElement element = driver.findElement(SelectBoxFechaFUR);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		driver.findElement(SelectBoxMetodoAnticonceptivo).clear();
		driver.findElement(SelectBoxMetodoAnticonceptivo).sendKeys(MetodoAnti);
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//*[@class='dx-scrollable-wrapper'])[8]/..//div[contains(text(),'"+MetodoAnti+"')]")).click();
		Thread.sleep(500);
		if (FechaInicio.indexOf("-") != -1) {
			FechaInicio = FechaInicio.replace("-", "/");
		}
		// FechaIniTrataAnticon
		driver.findElement(SelectBoxFechaIniTrataAnticon).click();
		driver.findElement(SelectBoxFechaIniTrataAnticon).clear();
		driver.findElement(SelectBoxFechaIniTrataAnticon).sendKeys(FechaInicio);
		Thread.sleep(500);
		if (FechaFin.indexOf("-") != -1) {
			FechaFin = FechaInicio.replace("-", "/");
		}
		// FechaFinTrataAnticon
		driver.findElement(SelectBoxFechaFinTrataAnticon).click();
		driver.findElement(SelectBoxFechaFinTrataAnticon).clear();
		driver.findElement(SelectBoxFechaFinTrataAnticon).sendKeys(FechaFin);
		Thread.sleep(500);
		}
		// UCitologia
		driver.findElement(SelectBtnCitologia).click();
		Thread.sleep(1000);
		// FechaUltCitologia
		driver.findElement(SelectBoxFechaCitologia).click();
		driver.findElement(SelectBoxFechaCitologia).clear();
		driver.findElement(SelectBoxFechaCitologia).sendKeys("11/6/2020");
		driver.findElement(SelectBoxFechaCitologia).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// ResultadoCitologia
		driver.findElement(BtnDropDownResultadoCitologia).click();
		Thread.sleep(1000);
		driver.findElement(SelectSelectListesultadoCitologia).click();
		Thread.sleep(1000);
		// OtrosAntecedentesGinecobstetricos
		driver.findElement(SelectBtnOtrosAntecedentesGinecobstetricos).click();
		driver.findElement(SelectBtnOtrosAntecedentesGinecobstetricos).clear();
		driver.findElement(SelectBtnOtrosAntecedentesGinecobstetricos).sendKeys("No reporta otros antecedentes");
		Thread.sleep(1000);
		WebElement element1 = driver.findElement(SelectBtnOtrosAntecedentesGinecobstetricos);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(3000);

	}	*/
	public static String getCellValueSString(int fila, int Columna, String pagina, String Libro) throws IOException {
		File file = new File("C:\\Users\\felipej\\git\\repository\\KlinicTestingFramework\\"+Libro+".xlsm");
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

	public static int getCellValuesInt(int fila, int Columna, String pagina, String Libro) throws IOException {
		File file = new File("C:\\Users\\felipej\\git\\repository\\KlinicTestingFramework\\"+Libro+".xlsm");
		FileInputStream InputStream = new FileInputStream(file);
		XSSFWorkbook newWorkBook = new XSSFWorkbook(InputStream);
		XSSFSheet newSheet = newWorkBook.getSheet(pagina);
		XSSFRow row = newSheet.getRow(fila);
		XSSFCell cell = row.getCell(Columna);
		return (int) cell.getNumericCellValue();
	}

	public static double getCellValuessDouble(int fila, int Columna, String pagina, String Libro) throws IOException {
		File file = new File("C:\\Users\\felipej\\git\\repository\\KlinicTestingFramework\\"+Libro+".xlsm");
		FileInputStream InputStream = new FileInputStream(file);
		XSSFWorkbook newWorkBook = new XSSFWorkbook(InputStream);
		XSSFSheet newSheet = newWorkBook.getSheet(pagina);
		XSSFRow row = newSheet.getRow(fila);
		XSSFCell cell = row.getCell(Columna);
		return (double) cell.getNumericCellValue();
	}

}