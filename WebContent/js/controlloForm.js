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
    console.log(x);
        if(x==null || x.lenght<6 || x.lenght>30)
        {
            alert("Inserire una password corretta. Almeno 6 caratteri.");
            return false;
        }

        if(x.lenght>30)
        {
            alert("Inserire una password più corta.");
            return false;
        }

    x=document.getElementById("email").value;
    console.log(x);
        if(x==null || x.lenght<10)
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
     console.log(x);
            if(x==null || x.lenght<3)
            {
                alert("Inserire un nome corretto.");
                return false;
            }

            if(x.lenght>15)
            {
                alert("Inserire un nome più breve.");
                return false;
            }

    x=document.getElementById("cognome").value;
    console.log(x);
        if(x==null || x.lenght<=3 || x.lenght>15)
        {
            alert("Inserire un cognome corretto.");
            return false;
        }

        if(x.length>15)
        {
            alert("Il cognome inserito è troppo lungo.");
            return false;
        }

    return true;
}

function cAnnuncioForm () //Controllo del form relativo all'inserimento di un annuncio.
{
    
    var x= document.getElementById("titolo").value;
    console.log(x);
        if (x==null || x.lenght<=3 || x.lenght>50)
        {
            alert("Inserire un titolo corretto.");
            return false;
        }

    x= document.getElementById("descrizione").value;
    console.log(x);
        if (x==null || x.lenght<=3)
        {
            alert("Inserire una descrizione corretta.");
            return false;
        }

        if(x.lenght>65535)
        {
            alert("La descrizione è troppo lunga.");
            return false;
        }

    return true;
}

function cLoginForm () //Controllo del form relativo al login.
{
    
    var x= document.getElementById("username").value;
    console.log(x);
        if(x==null || x.lenght<3 || x.lenght>15)
        {
            alert("Inserire un username corretto.");
            return false;
        }
    
    x=document.getElementById("password").value;
    console.log(x);
        if(x==null || x.lenght<6 || x.lenght>15)
        {
            alert("Inserire una password corretta.");
            return false;
        }
    
    return true;
}

function cUserAdmin() //Controllo del form relativo all'inserimento/rimozione di un Amministratore tramite username.
{
    
    var x= document.getElementById("username").value;
    console.log(x);
        if(x==null || x.lenght<3 || x.lenght>15)
        {
            alert("Inserire un username corretto.");
            return false;
        }
        
    return true;
}

function cPreferenzeForm () //Controllo del form relativo all'inserimento di una preferenza da parte di un amministratore.
{
    
    var x= document.getElementById("preferenza").value;
        if(x==null || x.lenght<3 || x.lenght>15)
        {
            alert("Inserire una preferenza corretta.");
            return false;
        }
    
    x=document.getElementById("id").value;
        if(x==null)
        {
            alert("Inserire un ID corretto.");
            return false;
        }
    return true;
}


function cRicercaForm() //Controllo del form relativo alla ricerca di un annuncio nella sezione bacheca.
{
    
    var x= document.getElementById("ricerca").value;
        if(x==null || x.lenght<3)
        {
            alert("Inserire una chiave di ricerca valida.");
            return false;
        }

        if(x.lenght>15)
        {
            alert("Inserire una chiave di ricerca più breve.");
            return false;
        }

        return true;
}

function cEmailForm() //Controllo form relativo al recupero password.
{
    var x= document.getElementById("email").value;
    console.log(x);
    if(x==null || x.lenght<10)
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

    return true;
}

