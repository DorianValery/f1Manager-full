import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PiloteInventaireComponent } from './pilote-inventaire.component';

describe('PiloteInventaireComponent', () => {
  let component: PiloteInventaireComponent;
  let fixture: ComponentFixture<PiloteInventaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PiloteInventaireComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PiloteInventaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
