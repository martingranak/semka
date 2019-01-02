import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RezervationsComponent } from './rezervations.component';

describe('RezervationsComponent', () => {
  let component: RezervationsComponent;
  let fixture: ComponentFixture<RezervationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RezervationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RezervationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
