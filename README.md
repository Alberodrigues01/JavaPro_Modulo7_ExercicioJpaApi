# JavaPro_Modulo7_ExercicioJpaApi
O exercício envolve a criação de três entidades (classes) principais: Patient (pacientes), Doctors(médicos reponsáveis pelas internações destes pacientes)
e HospitalizationHistory (correspondendo ao histórico das internações).
Além das entidades principais, também foram criadas duas entidades DTO`s para facilitar os processos de gerar os seguintes históricos de internações: 
HospitalizationsByPatients (internações por pacientes) e HospitalizationsByDoctors (internações por médicos).
O exerícico da criação/simulação de uma API REST obedece ao padrão adicional abrangendo as classes Models, Repositories, Services e Controllers.
O único aspecto complementar a esta estrutura tradicional foi a inclusão de uma classe Adapter para conter a lógica de execução 
dos processos de criação de listas de respostas as consultas HospitalizationsByPatients e HospitalizationsByDoctor.
O banco de dados utilizado foi o Postgres. Arquivo resource>application.properties contem as informaçoes de acesso ao banco de dados.
Os serviços REST tradicionais (GET, POST, PUT e DELETE) deve ser simulado utilizando o aplicativo Postman e os envios de parametros ou dados para inclusão
nos repositorios deve ser feito utilizando o padrão JSON.
Atentar especialmente para a estrutura do "script" JSON que deve ser enviado para inserção de informações nas tabelas

Patient:
{ 
    "name" : "Carla",
    "birthdate": "22/01/1989",
    "phone": "99999-1111"
}

Doctor:
{
    "name" : "Edson",
    "department" : "Cadiologia",
    "phone": "90000-1111"
}

E especialmente o HospitalizationHistory:
{
    "patient":{
    "id":"1"
    },
    "doctor_resp":[{
         "id": "2"
        }],
 
    "id":3,
    "dateEntry" : "17/07/2012 8h",
    "dateExit": "24/07/2012 14h",
    "description": "Arritimia"
}

O POST da alimentação das tabelas deve ser feito de uma inclusão por vez (um paciente por vez, um médico por vez e uma internação por vez).

