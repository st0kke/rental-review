/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st0kke.rentalreview.restservices.ejb;

import javax.ejb.Local;

/**
 *
 * @author 
 */
@Local
public interface PropertyFacade {
    
    int addProperty();
}
