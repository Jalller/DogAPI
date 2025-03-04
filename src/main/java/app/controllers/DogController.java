package app.controllers;

import app.dtos.DogDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DogController {

    private static List<DogDTO> dogs = new ArrayList(Arrays.asList(
            new DogDTO(1, "Fido", "Labrador", 'M', 4),
            new DogDTO(2, "Benjamin", "Danish Swedish Farm Dog", 'M', 2),
            new DogDTO(3, "Hannah", "Danish Swedish Farm Dog", 'F', 7)
    ));

    public DogDTO getById(int id) throws Exception{
        try{
            dogs.get(id);
        } catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return dogs.get(id);
    }

    public List<DogDTO> getAll(){
        return dogs;
    }

    public DogDTO setDog(int id, DogDTO dog){
        dogs.set(id, dog);
        return dog;
    }

    public DogDTO create(DogDTO dog){
        int id = dogs.size() + 1;
        dog.setId(id);
        dogs.add(dog);
        return dogs.get(id);
    }
}

//package app.controllers;
//
//import app.dtos.DogDTO;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class DogController {
//
//    private static Map<Integer, DogDTO> dogs = new HashMap<>(Map.of(
//            1, new DogDTO(1, "Fido", "Labrador", 'M', 4),
//            2, new DogDTO(2, "Benjamin", "Danish Swedish Farm Dog", 'M', 2),
//            3, new DogDTO(3, "Hannah", "Danish Swedish Farm Dog", 'F', 7)
//    ));
//
//    public Map<Integer, DogDTO> getAllDogs() {
//        return dogs;
//    }
//
//    public DogDTO getDogById(int id) throws Exception {
//        if (!dogs.containsKey(id)) {
//            throw new Exception("Dog not found");
//        }
//        return dogs.get(id);
//    }
//
//    public DogDTO createDog(DogDTO dog) {
//        int id = dogs.size() + 1;
//        dog.setId(id);
//        dogs.put(id, dog);
//        return dog;
//    }
//
//    public DogDTO updateDog(int id, DogDTO updatedDog) throws Exception {
//        if (!dogs.containsKey(id)) {
//            throw new Exception("Dog not found");
//        }
//        updatedDog.setId(id);
//        dogs.put(id, updatedDog);
//        return updatedDog;
//    }
//
//    public boolean deleteDog(int id) {
//        return dogs.remove(id) != null;
//    }
//}
