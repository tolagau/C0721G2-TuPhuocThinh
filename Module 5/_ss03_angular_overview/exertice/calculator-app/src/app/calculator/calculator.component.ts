import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  soA: number;
  soB: number;
  ketQua: number;

  constructor() {
  }

  ngOnInit(): void {
  }

  cong() {
    this.ketQua = this.soA + this.soB;
  }

  tru() {
    this.ketQua = this.soA- this.soB;
  }

  nhan() {
    this.ketQua = this.soA * this.soB;
  }

  chia() {
    this.ketQua = this.soA / this.soB;
  }
}
