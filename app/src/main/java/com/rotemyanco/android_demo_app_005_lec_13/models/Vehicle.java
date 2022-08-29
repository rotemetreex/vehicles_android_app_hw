package com.rotemyanco.android_demo_app_005_lec_13.models;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import java.util.List;





@Entity(tableName = "vehicle")
public class Vehicle {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String model;

    private String manufacturer;
    @SerializedName("cost_in_credits")
    private String cost;
    private String length;
    @SerializedName("max_atmosphering_speed")
    private String maxSpeed;
    private String crew;
    private String passengers;
    @SerializedName("cargo_capacity")
    private String cargoCapacity;
    private String consumables;
    @SerializedName("vehicle_class")
    private String vehicleClass;

//    private List<String> pilots;
//    private List<String> films;

    private String created;
    private String edited;
    private String url;



    public Vehicle() {
    }


//    public Vehicle(int id, String name, String model, String manufacturer, String cost, String length, String maxSpeed, String crew, String passengers, String cargoCapacity, String consumables, String vehicleClass, String created, String edited, String url) {
//        this.id = id;
//        this.name = name;
//        this.model = model;
//        this.manufacturer = manufacturer;
//        this.cost = cost;
//        this.length = length;
//        this.maxSpeed = maxSpeed;
//        this.crew = crew;
//        this.passengers = passengers;
//        this.cargoCapacity = cargoCapacity;
//        this.consumables = consumables;
//        this.vehicleClass = vehicleClass;
//        this.created = created;
//        this.edited = edited;
//        this.url = url;
//    }




    //    private Vehicle(Builder builder) {
//        this.id = builder.id;
//        this.name = builder.name;
//        this.model = builder.model;
//        this.manufacturer = builder.manufacturer;
//        this.cost = builder.cost;
//        this.length = builder.length;
//        this.maxSpeed = builder.maxSpeed;
//        this.crew = builder.crew;
//        this.passengers = builder.passengers;
//        this.cargoCapacity = builder.cargoCapacity;
//        this.consumables = builder.consumables;
//        this.vehicleClass = builder.vehicleClass;
//        this.pilots = builder.pilots;
//        this.films = builder.films;
//        this.created = builder.created;
//        this.edited = builder.edited;
//        this.url = builder.url;
//    }

//    public static class Builder {
//
//        private int id;
//        private String name;
//        private String model;
//        private String manufacturer;
//        private String cost;
//        private String length;
//        private String maxSpeed;
//        private String crew;
//        private String passengers;
//        private String cargoCapacity;
//        private String consumables;
//        private String vehicleClass;
//
//        private List<String> pilots;
//        private List<String> films;
//
//        private String created;
//        private String edited;
//        private String url;



//        public Builder() {}
//
//        public Builder id(int id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder model(String model) {
//            this.model = model;
//            return this;
//        }
//
//        public Builder manufacturer(String manufacturer) {
//            this.manufacturer = manufacturer;
//            return this;
//        }
//
//        public Builder cost(String cost) {
//            this.cost = cost;
//            return this;
//        }
//
//        public Builder length(String length) {
//            this.length = length;
//            return this;
//        }
//
//        public Builder maxSpeed(String maxSpeed) {
//            this.maxSpeed = maxSpeed;
//            return this;
//        }
//
//        public Builder passengers(String passengers) {
//            this.passengers = passengers;
//            return this;
//        }
//
//        public Builder crew(String crew) {
//            this.crew = crew;
//            return this;
//        }
//
//        public Builder cargoCapacity(String cargoCapacity) {
//            this.cargoCapacity = cargoCapacity;
//            return this;
//        }
//
//        public Builder consumables(String consumables) {
//            this.consumables = consumables;
//            return this;
//        }
//
//        public Builder vehicleClass(String vehicleClass) {
//            this.vehicleClass = vehicleClass;
//            return this;
//        }
//
//        public Builder pilots(List<String> pilots) {
//            this.pilots = pilots;
//            return this;
//        }
//
//        public Builder films(List<String> films) {
//            this.films = films;
//            return this;
//        }
//
//        public Builder created(String created) {
//            this.created = created;
//            return this;
//        }
//
//        public Builder edited(String edited) {
//            this.edited = edited;
//            return this;
//        }
//
//        public Builder url(String url) {
//            this.url = url;
//            return this;
//        }
//
//        public Vehicle build() {
//            return new Vehicle(this);
//        }
//    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

//    public List<String> getPilots() {
//        return pilots;
//    }
//
//    public void setPilots(List<String> pilots) {
//        this.pilots = pilots;
//    }
//
//    public List<String> getFilms() {
//        return films;
//    }
//
//    public void setFilms(List<String> films) {
//        this.films = films;
//    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cost='" + cost + '\'' +
                ", length='" + length + '\'' +
                ", maxSpeed='" + maxSpeed + '\'' +
                ", crew='" + crew + '\'' +
                ", passengers='" + passengers + '\'' +
                ", cargoCapacity='" + cargoCapacity + '\'' +
                ", consumables='" + consumables + '\'' +
                ", vehicleClass='" + vehicleClass + '\'' +
//                ", pilots=" + pilots +
//                ", films=" + films +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}








//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, MainFragment.newInstance())
//                    .commitNow();
//        }
//    }










//        {
//                "name": "Sand Crawler",
//                "model": "Digger Crawler",
//                "manufacturer": "Corellia Mining Corporation",
//                "cost_in_credits": "150000",
//                "length": "36.8 ",
//                "max_atmosphering_speed": "30",
//                "crew": "46",
//                "passengers": "30",
//                "cargo_capacity": "50000",
//                "consumables": "2 months",
//                "vehicle_class": "wheeled",
//                "pilots": [],
//                "films": [
//                "https://swapi.dev/api/films/1/",
//                "https://swapi.dev/api/films/5/"
//                ],
//                "created": "2014-12-10T15:36:25.724000Z",
//                "edited": "2014-12-20T21:30:21.661000Z",
//                "url": "https://swapi.dev/api/vehicles/4/"
//                }