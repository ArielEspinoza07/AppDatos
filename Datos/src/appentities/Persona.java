package appentities;

public class Persona {
    private String Cedula;
        private String Nombre;
        private String Apellidos;
        private String Telefono;
        private String Email;
        private int Estado;

        public Persona() {
        }

        public String getCedula() {
            return Cedula;
        }

        public void setCedula(String Cedula) {
            this.Cedula = Cedula;
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }

        public String getApellidos() {
            return Apellidos;
        }

        public void setApellidos(String Apellidos) {
            this.Apellidos = Apellidos;
        }

        public String getTelefono() {
            return Telefono;
        }

        public void setTelefono(String Telefono) {
            this.Telefono = Telefono;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public int getEstado() {
            return Estado;
        }

        public void setEstado(int Estado) {
            this.Estado = Estado;
        }
        
        public String toString(){
            String hil;
            
            hil="Cedula: "+this.getCedula()+"\nNombre: "+this.getNombre()+"\nApellidos: "+this.getApellidos()+"\nTelefono: "+this.getTelefono()+"\nEmail: "+this.getEmail()+"\n";
            
            return hil;
        }
}
