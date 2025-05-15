package com.example.aulamobile2.model;

public class Departamento {

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Departamento{" +
                    "name='" + name + '\'' +
                    '}';
        }
}
