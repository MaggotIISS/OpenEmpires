/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package panels;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 <p>
 @author Mark Ferguson
 */
@Retention(value = RetentionPolicy.RUNTIME)
@interface Annotation4T5 {

  String note();

  String ref();

  int line();
}
