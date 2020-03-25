# Spark-API
EC2 - S3 - RDS
<br>
En este turorial se demostrara cómo realizar un sitio web dinámico con los servicios de AWS. Se usaran los servicios: EC2, S3 y RDS. 
En S3 se desplegaran los archivos estáticos. 
En EC2 se desplegará una API Rest con Spark que repondera las peticiones. 
En RDS se creará una base de datos para almacenar informacion basica de pruba. 

El repositorio está disponible en: Patrones-Arquitecturales-AWS

**RDS**

1. Crear instancia de la base de datos 
2. Generar la configuración basica 
3. Crear un nuevo VPC 
4. Probar conexión con una herramienta de base de datos 
5. Crear tabla 
6. Editar la aplicación en java para que se conecte a la base de datos

**EC2**
1. Crear instancia en EC2 con java. 
2. Configrurar VPC 
4. Acceder a la instancia con ssh 
5. Añadir java 1.8 , mvn y git

Instalar java 1.8:

>sudo yum install java-1.8.0 

>sudo yum install java-1.8.0-openjdk-devel 

>sudo yum remove java-1.7.0-openjdk

Instalar mvn:

>sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo 

> "sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo" entrar a editar, error de slash


>sudo yum install -y apache-maven

Permitir que mvn use java 1.8:

>sudo update-alternatives --config java 

>sudo update-alternatives --config javac

Instalar git:

>sudo yum install git

6. Clonar la aplicacion 
El servidor debe estar configurado para aceptar peticiones CORS. 
7. Actualizar dependencias y ejecutar


**S3**
1. Crear bucket 
2. Subir archivos estáticos y ponerlos públicos Las peticiones deben ser redirigidas a la IP publica del EC2. 
3. Configurar permisos para permitit CORS
