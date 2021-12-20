import {Component, OnInit} from '@angular/core';
import {Pet} from '../pet';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {
  pet: Pet = {
    name: 'Bít',
    image: 'https://cdn.lazi.vn/storage/uploads/users/avatar/196505_1556724572.jpg'
  };

  constructor() {
  }

  ngOnInit(): void {
  }

}
