import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstadoticketComponent } from './estadoticket.component';

describe('EstadoticketComponent', () => {
  let component: EstadoticketComponent;
  let fixture: ComponentFixture<EstadoticketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EstadoticketComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstadoticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
