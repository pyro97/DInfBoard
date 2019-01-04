function cRegistrazioneForm () //Controllo del form relativo alla registrazione.
{
    
    var x= document.getElementById("username").value;
    console.log(x);
        if(x==null || x.lenght<3)
        {
            alert("Inserire un username corretto.");
            return false;
        }

        if(x.lenght>15)
        {
            alert("Inserire un username più corto.");
            return false;
        }

    x=document.getElementById("password").value;
        if(x.value==null || x.value.lenght<6 || x.value.lenght>30)
        {
            alert("Inserire una password corretta. Almeno 6 caratteri.");
            return false;
        }

        if(x.value.lenght>30)
        {
            alert("Inserire una password più corta.");
            return false;
        }

    x=document.getElementById("email").value;
        if(x.value==null || x.value.lenght<10)
        {
            alert("Inserire una mail corretta.");
            return false;
        }
    /*  ---DA PROVARE PER CONTROLLO SINTASSI EMAIL---
         var filtro = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$/;
            if (!filtro.test(x.email.value)) 
            {
            alert("Inserire una mail corretta.");
            return false;
        } */ 

     x=document.getElementById("nome").value;
            if(x.value==null || x.value.lenght<3)
            {
                alert("Inserire un nome corretto.");
                return false;
            }

            if(x.value.lenght>15)
            {
                alert("Inserire un nome più breve.");
                return false;
            }

    x=document.getElementById("cognome").value;
        if(x.value==null || x.value.lenght<=3 || x.value.lenght>15)
        {
            alert("Inserire un cognome corretto.");
            return false;
        }

    return true;
}

function cAnnuncioForm () //Controllo del form relativo all'inserimento di un annuncio.
{
    
    var x= document.getElementById("titolo");
        if (x.value==null || x.value.lenght<=3 || x.value.lenght>50)
        {
            alert("Inserire un titolo corretto.");
            return false;
        }

    x= document.getElementById("descrizione");
        if (x.value==null || x.value.lenght<=3)
        {
            alert("Inserire una descrizione corretta.");
            return false;
        }

        if(x.value.lenght>65535)
        {
            alert("La descrizione è troppo lunga.");
            return false;
        }

    return true;
}

function cLoginForm () //Controllo del form relativo al login.
{
    
    var x= document.getElementById("username");
        if(x.value==null || x.value.lenght<3 || x.value.lenght>15)
        {
            alert("Inserire un username corretto.");
            return false;
        }
            x=document.getElementById("password");
        if(x.value==null || x.value.lenght<6 || x.value.lenght>15)
        {
            alert("Inserire una password corretta.");
            return false;
        }
    
    return true;
}

function cUserAdmin() //Controllo del form relativo all'inserimento/rimozione di un Amministratore tramite username.
{
    
    var x= document.getElementById("username");
        if(x.value==null || x.value.lenght<3 || x.value.lenght>15)
        {
            alert("Inserire un username corretto.");
            return false;
        }
        
    return true;
}

function cPreferenzeForm () //Controllo del form relativo all'inserimento di una preferenza da parte di un amministratore.
{
    
    var x= document.getElementById("preferenza");
        if(x.value==null || x.value.lenght<3 || x.value.lenght>15)
        {
            alert("Inserire una preferenza corretta.");
            return false;
        }

    return true;
}

function cRicercaForm() //Controllo del form relativo alla ricerca di un annuncio nella sezione bacheca.
{
    
    var x= document.getElementById("ricerca");
        if(x.value==null || x.value.lenght<3)
        {
            alert("Inserire una chiave di ricerca valida.");
            return false;
        }

        if(x.value.lenght>15)
        {
            alert("Inserire una chiave di ricerca più breve.");
            return false;
        }

        return true;
}