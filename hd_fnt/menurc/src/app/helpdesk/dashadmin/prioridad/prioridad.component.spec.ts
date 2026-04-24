import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrioridadComponent } from './prioridad.component';

describe('PrioridadComponent', () => {
  let component: PrioridadComponent;
  let fixture: ComponentFixture<PrioridadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrioridadComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrioridadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
