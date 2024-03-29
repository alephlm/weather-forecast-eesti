package com.wf.weatherforecast.repositories;
import com.wf.weatherforecast.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByName(String name);
}
