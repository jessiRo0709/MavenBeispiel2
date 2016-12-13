package de.jessi;

import java.util.List;

import de.jessi.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();

}